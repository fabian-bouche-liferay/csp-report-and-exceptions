/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CSPViolation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CSPViolation
 * @generated
 */
public class CSPViolationWrapper
	extends BaseModelWrapper<CSPViolation>
	implements CSPViolation, ModelWrapper<CSPViolation> {

	public CSPViolationWrapper(CSPViolation cspViolation) {
		super(cspViolation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("cspViolationId", getCspViolationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("plid", getPlid());
		attributes.put("url", getUrl());
		attributes.put("violationType", getViolationType());
		attributes.put("violation", getViolation());
		attributes.put("violationHash", getViolationHash());
		attributes.put("whiteListed", isWhiteListed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long cspViolationId = (Long)attributes.get("cspViolationId");

		if (cspViolationId != null) {
			setCspViolationId(cspViolationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long plid = (Long)attributes.get("plid");

		if (plid != null) {
			setPlid(plid);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String violationType = (String)attributes.get("violationType");

		if (violationType != null) {
			setViolationType(violationType);
		}

		String violation = (String)attributes.get("violation");

		if (violation != null) {
			setViolation(violation);
		}

		String violationHash = (String)attributes.get("violationHash");

		if (violationHash != null) {
			setViolationHash(violationHash);
		}

		Boolean whiteListed = (Boolean)attributes.get("whiteListed");

		if (whiteListed != null) {
			setWhiteListed(whiteListed);
		}
	}

	@Override
	public CSPViolation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this csp violation.
	 *
	 * @return the company ID of this csp violation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this csp violation.
	 *
	 * @return the create date of this csp violation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the csp violation ID of this csp violation.
	 *
	 * @return the csp violation ID of this csp violation
	 */
	@Override
	public long getCspViolationId() {
		return model.getCspViolationId();
	}

	/**
	 * Returns the group ID of this csp violation.
	 *
	 * @return the group ID of this csp violation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this csp violation.
	 *
	 * @return the modified date of this csp violation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the plid of this csp violation.
	 *
	 * @return the plid of this csp violation
	 */
	@Override
	public long getPlid() {
		return model.getPlid();
	}

	/**
	 * Returns the primary key of this csp violation.
	 *
	 * @return the primary key of this csp violation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the url of this csp violation.
	 *
	 * @return the url of this csp violation
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this csp violation.
	 *
	 * @return the user ID of this csp violation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this csp violation.
	 *
	 * @return the user name of this csp violation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this csp violation.
	 *
	 * @return the user uuid of this csp violation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this csp violation.
	 *
	 * @return the uuid of this csp violation
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the violation of this csp violation.
	 *
	 * @return the violation of this csp violation
	 */
	@Override
	public String getViolation() {
		return model.getViolation();
	}

	/**
	 * Returns the violation hash of this csp violation.
	 *
	 * @return the violation hash of this csp violation
	 */
	@Override
	public String getViolationHash() {
		return model.getViolationHash();
	}

	/**
	 * Returns the violation type of this csp violation.
	 *
	 * @return the violation type of this csp violation
	 */
	@Override
	public String getViolationType() {
		return model.getViolationType();
	}

	/**
	 * Returns the white listed of this csp violation.
	 *
	 * @return the white listed of this csp violation
	 */
	@Override
	public boolean getWhiteListed() {
		return model.getWhiteListed();
	}

	/**
	 * Returns <code>true</code> if this csp violation is white listed.
	 *
	 * @return <code>true</code> if this csp violation is white listed; <code>false</code> otherwise
	 */
	@Override
	public boolean isWhiteListed() {
		return model.isWhiteListed();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this csp violation.
	 *
	 * @param companyId the company ID of this csp violation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this csp violation.
	 *
	 * @param createDate the create date of this csp violation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the csp violation ID of this csp violation.
	 *
	 * @param cspViolationId the csp violation ID of this csp violation
	 */
	@Override
	public void setCspViolationId(long cspViolationId) {
		model.setCspViolationId(cspViolationId);
	}

	/**
	 * Sets the group ID of this csp violation.
	 *
	 * @param groupId the group ID of this csp violation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this csp violation.
	 *
	 * @param modifiedDate the modified date of this csp violation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the plid of this csp violation.
	 *
	 * @param plid the plid of this csp violation
	 */
	@Override
	public void setPlid(long plid) {
		model.setPlid(plid);
	}

	/**
	 * Sets the primary key of this csp violation.
	 *
	 * @param primaryKey the primary key of this csp violation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the url of this csp violation.
	 *
	 * @param url the url of this csp violation
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this csp violation.
	 *
	 * @param userId the user ID of this csp violation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this csp violation.
	 *
	 * @param userName the user name of this csp violation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this csp violation.
	 *
	 * @param userUuid the user uuid of this csp violation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this csp violation.
	 *
	 * @param uuid the uuid of this csp violation
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the violation of this csp violation.
	 *
	 * @param violation the violation of this csp violation
	 */
	@Override
	public void setViolation(String violation) {
		model.setViolation(violation);
	}

	/**
	 * Sets the violation hash of this csp violation.
	 *
	 * @param violationHash the violation hash of this csp violation
	 */
	@Override
	public void setViolationHash(String violationHash) {
		model.setViolationHash(violationHash);
	}

	/**
	 * Sets the violation type of this csp violation.
	 *
	 * @param violationType the violation type of this csp violation
	 */
	@Override
	public void setViolationType(String violationType) {
		model.setViolationType(violationType);
	}

	/**
	 * Sets whether this csp violation is white listed.
	 *
	 * @param whiteListed the white listed of this csp violation
	 */
	@Override
	public void setWhiteListed(boolean whiteListed) {
		model.setWhiteListed(whiteListed);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CSPViolationWrapper wrap(CSPViolation cspViolation) {
		return new CSPViolationWrapper(cspViolation);
	}

}