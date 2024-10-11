package com.liferay.samples.fbo.csp.manager.servlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.cookies.CookiesManagerUtil;
import com.liferay.portal.kernel.cookies.constants.CookiesConstants;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.samples.fbo.csp.manager.exception.NoSuchCSPViolationException;
import com.liferay.samples.fbo.csp.manager.model.CSPViolation;
import com.liferay.samples.fbo.csp.manager.service.CSPViolationLocalService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"osgi.http.whiteboard.context.path=/",
			"osgi.http.whiteboard.servlet.pattern=/csp-report"
		},
		service = Servlet.class
	)
public class CSPReportServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder jsonBuffer = new StringBuilder();
        String line = null;
        
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }
        }
        
        JSONObject jsonObject;
		try {
			jsonObject = JSONFactoryUtil.createJSONObject(jsonBuffer.toString());

			String url = jsonObject.getJSONObject("csp-report").getString("document-uri");
	        int lineNumber = jsonObject.getJSONObject("csp-report").getInt("line-number");
	        String jsessionid = CookiesManagerUtil.getCookieValue(CookiesConstants.NAME_JSESSIONID, request);

			String violatedDirective = jsonObject.getJSONObject("csp-report").getString("violated-directive");

			if(_log.isDebugEnabled()) {
				_log.debug("A violation has been reported: " + jsonObject.toJSONString());
			}
			
	        InlineKey key = new InlineKey(jsessionid, lineNumber, url);
	        InlineCacheItem cacheItem = _cspCacheManager.get(key);
	        
	        if(cacheItem != null) {

		        String script = cacheItem.getViolation();
		        long plid = cacheItem.getPlid();
		        String violationHash = cacheItem.getViolationHash();
		        long groupId = cacheItem.getGroupId();
		        Date now = new Date();
		        
//		        System.out.println(" * " + url + " (" + lineNumber + ") - " + jsessionid + ": " + script + " " + violatedDirective + " " + plid);
		        
		        try {
					_cspViolationLocalService.getCSPViolationByPlidAndHash(plid, violationHash);
				} catch (NoSuchCSPViolationException e) {
			        long cspViolationId = _counterLocalService.increment(CSPViolation.class.getName());
			        CSPViolation cspViolation = _cspViolationLocalService.createCSPViolation(cspViolationId);
			        cspViolation.setCreateDate(now);
			        cspViolation.setModifiedDate(now);
			        cspViolation.setCompanyId(CompanyThreadLocal.getCompanyId());
			        cspViolation.setGroupId(groupId);
			        cspViolation.setViolation(script);
			        cspViolation.setViolationHash(violationHash);
			        cspViolation.setViolationType(violatedDirective);
			        cspViolation.setPlid(plid);
			        cspViolation.setUrl(url);
			        cspViolation.setWhiteListed(false);
			        _cspViolationLocalService.addCSPViolation(cspViolation);
				}

	        	
	        }
	        

		} catch (JSONException e) {
			_log.error("Received bad CSP report", e);
		}
    
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@Reference
	private CSPCacheManager _cspCacheManager;
	
	@Reference
	private CSPViolationLocalService _cspViolationLocalService;
	
	@Reference
	private CounterLocalService _counterLocalService;
	
	private static final Log _log = LogFactoryUtil.getLog(CSPReportServlet.class);
	
}
