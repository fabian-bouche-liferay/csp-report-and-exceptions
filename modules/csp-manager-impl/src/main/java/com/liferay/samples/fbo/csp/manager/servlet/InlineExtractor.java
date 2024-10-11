package com.liferay.samples.fbo.csp.manager.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HexFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		service = InlineExtractor.class
		)
public class InlineExtractor {

	private MessageDigest _digest;
	
	private static final int CAPTURE_MAX = 60;
	
	@Activate
	public void activate() {
		try {
			_digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			_log.error("Failed to initiate SHA-256");
		}		
	}
	
    public void findInlineScripts(String html, String jsessionid, String url, long plid, long groupId) {

    	Pattern onXXXPattern = Pattern.compile("\\b(on\\w+)\\s*=\\s*\"(.*?)\"");
        Pattern scriptTagPattern = Pattern.compile("<script[^>]*>(.*?)</script>", Pattern.DOTALL);
    	Pattern stylePattern = Pattern.compile("\\b(style)\\s*=\\s*\"(.*?)\"");
        Pattern styleTagPattern = Pattern.compile("<style[^>]*>(.*?)</style>", Pattern.DOTALL);

        // Match the whole HTML for <script> tags
        Matcher scriptMatcher = scriptTagPattern.matcher(html);
        while (scriptMatcher.find()) {
            String scriptContent = scriptMatcher.group(1).trim();
            int lineNumber = getLineNumber(html, scriptMatcher.start());
            if (!scriptContent.isEmpty()) {
            	String violationHash = Base64.getEncoder().encodeToString(_digest.digest(scriptMatcher.group(1).getBytes(StandardCharsets.UTF_8)));
                String truncatedContent = scriptContent.length() > CAPTURE_MAX ? scriptContent.substring(0, CAPTURE_MAX) + "..." : scriptContent;
                truncatedContent = truncatedContent.replace("\n", "");
                //System.out.println("Hash " + violationHash + " for " + truncatedContent);                
                InlineKey key = new InlineKey(jsessionid, lineNumber, url);
    	        //System.out.println(" + " + url + " (" + lineNumber + ") - " + jsessionid + ": " + truncatedContent);
    	        _cspCacheManager.put(key, new InlineCacheItem(truncatedContent, violationHash, plid, groupId));
            }
        }
        
        // Match the whole HTML for <style> tags
        Matcher styleTagMatcher = styleTagPattern.matcher(html);
        while (styleTagMatcher.find()) {
            String styleContent = styleTagMatcher.group(1).trim();
            int lineNumber = getLineNumber(html, styleTagMatcher.start());
            if (!styleContent.isEmpty()) {
            	String violationHash = Base64.getEncoder().encodeToString(_digest.digest(styleTagMatcher.group(1).getBytes(StandardCharsets.UTF_8)));
                String truncatedContent = styleContent.length() > CAPTURE_MAX ? styleContent.substring(0, CAPTURE_MAX) + "..." : styleContent;
                truncatedContent = truncatedContent.replace("\n", "");
                InlineKey key = new InlineKey(jsessionid, lineNumber, url);
    	        //System.out.println(" + " + url + " (" + lineNumber + ") - " + jsessionid + ": " + truncatedContent);
    	        _cspCacheManager.put(key, new InlineCacheItem(truncatedContent, violationHash, plid, groupId));
            }
        }

        // Match the whole HTML for onXXX="" attributes
        Matcher onXXXMatcher = onXXXPattern.matcher(html);
        while (onXXXMatcher.find()) {
            String attribute = onXXXMatcher.group(1);
            String inlineScript = onXXXMatcher.group(2);
            int lineNumber = getLineNumber(html, onXXXMatcher.start());
        	String violationHash = Base64.getEncoder().encodeToString(_digest.digest(inlineScript.getBytes(StandardCharsets.UTF_8)));
            InlineKey key = new InlineKey(jsessionid, lineNumber, url);
	        //System.out.println(" + " + url + " (" + lineNumber + ") - " + jsessionid + ": " + attribute + "=\"" + inlineScript + "\"");
	        _cspCacheManager.put(key, new InlineCacheItem(attribute + "=\"" + inlineScript + "\"", violationHash, plid, groupId));
        }
        
        // Match the whole HTML for style="" attributes
        Matcher styleMatcher = stylePattern.matcher(html);
        while (styleMatcher.find()) {
            String attribute = styleMatcher.group(1);
            String inlineStyle = styleMatcher.group(2);
            int lineNumber = getLineNumber(html, styleMatcher.start());
        	String violationHash = Base64.getEncoder().encodeToString(_digest.digest(inlineStyle.getBytes(StandardCharsets.UTF_8)));
            InlineKey key = new InlineKey(jsessionid, lineNumber, url);
	        //System.out.println(" + " + url + " (" + lineNumber + ") - " + jsessionid + ": " + attribute + "=\"" + inlineStyle + "\"");
	        _cspCacheManager.put(key, new InlineCacheItem(attribute + "=\"" + inlineStyle + "\"", violationHash, plid, groupId));
        }
    }

    public int getLineNumber(String html, int position) {
    	CharSequence beforeString = html.subSequence(0, position);
    	return (int) beforeString.chars().filter(ch -> ch == '\n')  // filter for line breaks
        .count() + 1;
    }

	@Reference
	private CSPCacheManager _cspCacheManager;

	private static final Log _log = LogFactoryUtil.getLog(InlineExtractor.class);
}
