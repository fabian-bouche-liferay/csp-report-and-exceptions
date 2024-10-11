package com.liferay.samples.fbo.csp.manager.servlet;

import com.liferay.portal.kernel.cookies.CookiesManagerUtil;
import com.liferay.portal.kernel.cookies.constants.CookiesConstants;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.samples.fbo.csp.manager.model.CSPViolation;
import com.liferay.samples.fbo.csp.manager.service.CSPViolationLocalService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"service.ranking:Integer=999",
			"servlet-context-name=",
			"servlet-filter-name=CSP Filter",
			"url-pattern=/*",
			"before-filter=Virtual Host Filter"
		},
		service = Filter.class
)
public class CSPFilter implements Filter {

	private static final String TEXT_HTML = "text/html";
	private static final String ALL = "*/*";
	private static final String ACCEPT_HEADER_NAME = "Accept";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	private boolean skipRequest(HttpServletRequest httpServletRequest) {

		String acceptHeader = httpServletRequest.getHeader(ACCEPT_HEADER_NAME);
		if(acceptHeader == null || !(acceptHeader.contains(TEXT_HTML) || acceptHeader.contains(ALL))) {
			return true;
		}
		
		if("/c".equals(httpServletRequest.getRequestURI())) {
			return true;
		}

		if(httpServletRequest.getRequestURI().startsWith("/o/")) {
			return true;
		}

		if(httpServletRequest.getRequestURI().startsWith("/combo")) {
			return true;
		}

		return false;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		if(skipRequest(httpServletRequest)) {
			chain.doFilter(httpServletRequest, response);
			return;
		}
		
		CachingHttpServletResponseWrapper responseWrapper = new CachingHttpServletResponseWrapper((HttpServletResponse) response);

		chain.doFilter(request, responseWrapper);

        String contentType = responseWrapper.getContentType();
        if (contentType != null && contentType.contains("text/html")) {
    		String cachedResponseBody = responseWrapper.getCachedContent();

    		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    		
    		_inlineExtractor.findInlineScripts(
    				cachedResponseBody,
    				CookiesManagerUtil.getCookieValue(CookiesConstants.NAME_JSESSIONID, httpServletRequest),
    				httpServletRequest.getRequestURL().toString(),
    				themeDisplay.getPlid(),
    				themeDisplay.getSiteGroupId());

    		List<CSPViolation> whiteListedViolations = _cspViolationLocalService.getWhiteListedCSPViolationsByPlid(themeDisplay.getPlid());
    		
    		String scriptSrcHash = "";
    		String styleSrcHash = "";
    		
    		for(int i = 0; i < whiteListedViolations.size(); i++) {
    			CSPViolation violation = whiteListedViolations.get(i);
    			//System.out.println(" -> " + violation.getViolationType() + " " + violation.getViolationHash());
    			if("script-src-elem".equals(violation.getViolationType())) {
    				scriptSrcHash += (" 'sha256-" + violation.getViolationHash() + "'");
    			} else if("style-src-elem".equals(violation.getViolationType())) {
    				styleSrcHash += (" 'sha256-" + violation.getViolationHash() + "'");
    			} 
    		}
    		
    		responseWrapper.setHeader("Content-Security-Policy-Report-Only", 
    				"default-src 'none'; script-src 'self'" + scriptSrcHash + "; style-src 'self'" + styleSrcHash + "; img-src 'self'; " +
    				"font-src 'self'; connect-src 'self'; frame-src 'none'; object-src 'none'; " +
    				"report-uri /o/csp-report");
    		
    		response.getWriter().write(cachedResponseBody);
    		
        } else {
        	response.getOutputStream().write(responseWrapper.getBytes());
        }
        
	}

	@Override
	public void destroy() {
	}

	private class CachingHttpServletResponseWrapper extends HttpServletResponseWrapper {

		private ByteArrayOutputStream outputStream;
		private PrintWriter writer;

		public CachingHttpServletResponseWrapper(HttpServletResponse response) {
			super(response);
			this.outputStream = new ByteArrayOutputStream();
		}

	    public byte[] getBytes() throws IOException {
	        return outputStream.toByteArray();
	    }

		@Override
		public PrintWriter getWriter() throws IOException {
			if (writer == null) {
				writer = new PrintWriter(outputStream, true);
			}
			return writer;
		}

		public String getCachedContent() throws IOException {
			if (writer == null) {
				writer = new PrintWriter(outputStream, true);
			}			
			writer.flush(); 
			return outputStream.toString();
		}

	}
	
	@Reference
	private InlineExtractor _inlineExtractor;
	
	@Reference
	private CSPViolationLocalService _cspViolationLocalService;
}
