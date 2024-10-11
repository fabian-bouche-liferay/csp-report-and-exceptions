/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CSPViolation service. Represents a row in the &quot;FOO_CSPViolation&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CSPViolationModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.samples.fbo.csp.manager.model.impl.CSPViolationImpl"
)
@ProviderType
public interface CSPViolation extends CSPViolationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.samples.fbo.csp.manager.model.impl.CSPViolationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CSPViolation, Long> CSP_VIOLATION_ID_ACCESSOR =
		new Accessor<CSPViolation, Long>() {

			@Override
			public Long get(CSPViolation cspViolation) {
				return cspViolation.getCspViolationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CSPViolation> getTypeClass() {
				return CSPViolation.class;
			}

		};

}