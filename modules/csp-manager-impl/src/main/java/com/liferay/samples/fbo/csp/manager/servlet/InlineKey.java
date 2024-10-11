package com.liferay.samples.fbo.csp.manager.servlet;

import java.io.Serializable;

public class InlineKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String _jsessionid;
	private int _lineNumber;
	private String _url;
	
	public String getJsessionid() {
		return _jsessionid;
	}
	
	public void setJsessionid(String jsessionid) {
		this._jsessionid = jsessionid;
	}
	
	public int getLineNumber() {
		return _lineNumber;
	}
	
	public void setLineNumber(int lineNumber) {
		this._lineNumber = lineNumber;
	}
	
	public String getUrl() {
		return _url;
	}
	
	public void setUrl(String url) {
		this._url = url;
	}

	public InlineKey(String jsessionid, int lineNumber, String url) {
		super();
		this._jsessionid = jsessionid;
		this._lineNumber = lineNumber;
		this._url = url;
	}
	
	@Override
	public String toString() {
		return this._jsessionid + "#" + this._lineNumber + "#" + this._url;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(_url == null || _jsessionid == null) return false;
		if(obj instanceof InlineKey) {
			InlineKey key = (InlineKey) obj;
			return _jsessionid.equals(key._jsessionid) && _url.equals(key._url) && _lineNumber == key._lineNumber;			
		}
		return false;
	}
	
}
