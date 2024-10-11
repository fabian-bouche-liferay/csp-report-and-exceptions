/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.samples.fbo.csp.manager.model.CSPViolation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CSPViolation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CSPViolationCacheModel
	implements CacheModel<CSPViolation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CSPViolationCacheModel)) {
			return false;
		}

		CSPViolationCacheModel cspViolationCacheModel =
			(CSPViolationCacheModel)object;

		if (cspViolationId == cspViolationCacheModel.cspViolationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cspViolationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", cspViolationId=");
		sb.append(cspViolationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", plid=");
		sb.append(plid);
		sb.append(", url=");
		sb.append(url);
		sb.append(", violationType=");
		sb.append(violationType);
		sb.append(", violation=");
		sb.append(violation);
		sb.append(", violationHash=");
		sb.append(violationHash);
		sb.append(", whiteListed=");
		sb.append(whiteListed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CSPViolation toEntityModel() {
		CSPViolationImpl cspViolationImpl = new CSPViolationImpl();

		if (uuid == null) {
			cspViolationImpl.setUuid("");
		}
		else {
			cspViolationImpl.setUuid(uuid);
		}

		cspViolationImpl.setCspViolationId(cspViolationId);
		cspViolationImpl.setGroupId(groupId);
		cspViolationImpl.setCompanyId(companyId);
		cspViolationImpl.setUserId(userId);

		if (userName == null) {
			cspViolationImpl.setUserName("");
		}
		else {
			cspViolationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cspViolationImpl.setCreateDate(null);
		}
		else {
			cspViolationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cspViolationImpl.setModifiedDate(null);
		}
		else {
			cspViolationImpl.setModifiedDate(new Date(modifiedDate));
		}

		cspViolationImpl.setPlid(plid);

		if (url == null) {
			cspViolationImpl.setUrl("");
		}
		else {
			cspViolationImpl.setUrl(url);
		}

		if (violationType == null) {
			cspViolationImpl.setViolationType("");
		}
		else {
			cspViolationImpl.setViolationType(violationType);
		}

		if (violation == null) {
			cspViolationImpl.setViolation("");
		}
		else {
			cspViolationImpl.setViolation(violation);
		}

		if (violationHash == null) {
			cspViolationImpl.setViolationHash("");
		}
		else {
			cspViolationImpl.setViolationHash(violationHash);
		}

		cspViolationImpl.setWhiteListed(whiteListed);

		cspViolationImpl.resetOriginalValues();

		return cspViolationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		cspViolationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		plid = objectInput.readLong();
		url = objectInput.readUTF();
		violationType = objectInput.readUTF();
		violation = objectInput.readUTF();
		violationHash = objectInput.readUTF();

		whiteListed = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(cspViolationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(plid);

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (violationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(violationType);
		}

		if (violation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(violation);
		}

		if (violationHash == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(violationHash);
		}

		objectOutput.writeBoolean(whiteListed);
	}

	public String uuid;
	public long cspViolationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long plid;
	public String url;
	public String violationType;
	public String violation;
	public String violationHash;
	public boolean whiteListed;

}