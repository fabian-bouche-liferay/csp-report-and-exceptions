/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.samples.fbo.csp.manager.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCSPViolationException extends NoSuchModelException {

	public NoSuchCSPViolationException() {
	}

	public NoSuchCSPViolationException(String msg) {
		super(msg);
	}

	public NoSuchCSPViolationException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCSPViolationException(Throwable throwable) {
		super(throwable);
	}

}