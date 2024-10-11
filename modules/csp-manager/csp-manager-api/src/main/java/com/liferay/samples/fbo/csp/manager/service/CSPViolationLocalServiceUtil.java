/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.samples.fbo.csp.manager.model.CSPViolation;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CSPViolation. This utility wraps
 * <code>com.liferay.samples.fbo.csp.manager.service.impl.CSPViolationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CSPViolationLocalService
 * @generated
 */
public class CSPViolationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.samples.fbo.csp.manager.service.impl.CSPViolationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the csp violation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CSPViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cspViolation the csp violation
	 * @return the csp violation that was added
	 */
	public static CSPViolation addCSPViolation(CSPViolation cspViolation) {
		return getService().addCSPViolation(cspViolation);
	}

	/**
	 * Creates a new csp violation with the primary key. Does not add the csp violation to the database.
	 *
	 * @param cspViolationId the primary key for the new csp violation
	 * @return the new csp violation
	 */
	public static CSPViolation createCSPViolation(long cspViolationId) {
		return getService().createCSPViolation(cspViolationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the csp violation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CSPViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cspViolation the csp violation
	 * @return the csp violation that was removed
	 */
	public static CSPViolation deleteCSPViolation(CSPViolation cspViolation) {
		return getService().deleteCSPViolation(cspViolation);
	}

	/**
	 * Deletes the csp violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CSPViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation that was removed
	 * @throws PortalException if a csp violation with the primary key could not be found
	 */
	public static CSPViolation deleteCSPViolation(long cspViolationId)
		throws PortalException {

		return getService().deleteCSPViolation(cspViolationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.samples.fbo.csp.manager.model.impl.CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.samples.fbo.csp.manager.model.impl.CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CSPViolation fetchCSPViolation(long cspViolationId) {
		return getService().fetchCSPViolation(cspViolationId);
	}

	/**
	 * Returns the csp violation matching the UUID and group.
	 *
	 * @param uuid the csp violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchCSPViolationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCSPViolationByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the csp violation with the primary key.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation
	 * @throws PortalException if a csp violation with the primary key could not be found
	 */
	public static CSPViolation getCSPViolation(long cspViolationId)
		throws PortalException {

		return getService().getCSPViolation(cspViolationId);
	}

	public static CSPViolation getCSPViolationByPlidAndHash(
			long plid, String hash)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getService().getCSPViolationByPlidAndHash(plid, hash);
	}

	/**
	 * Returns the csp violation matching the UUID and group.
	 *
	 * @param uuid the csp violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching csp violation
	 * @throws PortalException if a matching csp violation could not be found
	 */
	public static CSPViolation getCSPViolationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCSPViolationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the csp violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.samples.fbo.csp.manager.model.impl.CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @return the range of csp violations
	 */
	public static List<CSPViolation> getCSPViolations(int start, int end) {
		return getService().getCSPViolations(start, end);
	}

	public static List<CSPViolation> getCSPViolationsByPlid(long plid) {
		return getService().getCSPViolationsByPlid(plid);
	}

	/**
	 * Returns all the csp violations matching the UUID and company.
	 *
	 * @param uuid the UUID of the csp violations
	 * @param companyId the primary key of the company
	 * @return the matching csp violations, or an empty list if no matches were found
	 */
	public static List<CSPViolation> getCSPViolationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCSPViolationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of csp violations matching the UUID and company.
	 *
	 * @param uuid the UUID of the csp violations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching csp violations, or an empty list if no matches were found
	 */
	public static List<CSPViolation> getCSPViolationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getService().getCSPViolationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of csp violations.
	 *
	 * @return the number of csp violations
	 */
	public static int getCSPViolationsCount() {
		return getService().getCSPViolationsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static List<CSPViolation> getWhiteListedCSPViolationsByPlid(
		long plid) {

		return getService().getWhiteListedCSPViolationsByPlid(plid);
	}

	/**
	 * Updates the csp violation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CSPViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cspViolation the csp violation
	 * @return the csp violation that was updated
	 */
	public static CSPViolation updateCSPViolation(CSPViolation cspViolation) {
		return getService().updateCSPViolation(cspViolation);
	}

	public static CSPViolationLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CSPViolationLocalService> _serviceSnapshot =
		new Snapshot<>(
			CSPViolationLocalServiceUtil.class, CSPViolationLocalService.class);

}