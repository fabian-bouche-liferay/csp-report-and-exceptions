package com.liferay.samples.fbo.csp.manager.servlet;

public class InlineCacheItem {

	private String _violation;
	private String _violationHash;
	private long _groupId;
	private long _plid;

	public String getViolation() {
		return _violation;
	}
	
	public void setViolation(String violation) {
		this._violation = violation;
	}
	
	public String getViolationHash() {
		return _violationHash;
	}
	
	public void setViolationHash(String violationHash) {
		this._violationHash = violationHash;
	}
	
	public long getPlid() {
		return _plid;
	}
	
	public void setPlid(long plid) {
		this._plid = plid;
	}
	
	public long getGroupId() {
		return this._groupId;
	}
	
	public void setGroupId(long groupId) {
		this._groupId = groupId;
	}

	public InlineCacheItem(String violation, String violationHash, long plid, long groupId) {
		super();
		this._violation = violation;
		this._violationHash = violationHash;
		this._plid = plid;
		this._groupId = groupId;
	}
		
}
