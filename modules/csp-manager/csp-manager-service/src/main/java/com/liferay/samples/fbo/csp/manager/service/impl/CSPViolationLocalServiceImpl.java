/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.samples.fbo.csp.manager.exception.NoSuchCSPViolationException;
import com.liferay.samples.fbo.csp.manager.model.CSPViolation;
import com.liferay.samples.fbo.csp.manager.service.base.CSPViolationLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.samples.fbo.csp.manager.model.CSPViolation",
	service = AopService.class
)
public class CSPViolationLocalServiceImpl
	extends CSPViolationLocalServiceBaseImpl {
	
	public List<CSPViolation> getCSPViolationsByPlid(long plid) {
		return cspViolationPersistence.findByPlid(plid);
	}

	public List<CSPViolation> getWhiteListedCSPViolationsByPlid(long plid) {
		return cspViolationPersistence.findByPlid_WhiteListed(plid, true);
	}
	
	public CSPViolation getCSPViolationByPlidAndHash(long plid, String hash) throws NoSuchCSPViolationException {
		return cspViolationPersistence.findByPlid_Hash(plid, hash);
	}
	
}