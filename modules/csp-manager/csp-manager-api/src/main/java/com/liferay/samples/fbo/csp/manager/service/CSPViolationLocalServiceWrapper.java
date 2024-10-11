/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CSPViolationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CSPViolationLocalService
 * @generated
 */
public class CSPViolationLocalServiceWrapper
	implements CSPViolationLocalService,
			   ServiceWrapper<CSPViolationLocalService> {

	public CSPViolationLocalServiceWrapper() {
		this(null);
	}

	public CSPViolationLocalServiceWrapper(
		CSPViolationLocalService cspViolationLocalService) {

		_cspViolationLocalService = cspViolationLocalService;
	}

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
	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
		addCSPViolation(
			com.liferay.samples.fbo.csp.manager.model.CSPViolation
				cspViolation) {

		return _cspViolationLocalService.addCSPViolation(cspViolation);
	}

	/**
	 * Creates a new csp violation with the primary key. Does not add the csp violation to the database.
	 *
	 * @param cspViolationId the primary key for the new csp violation
	 * @return the new csp violation
	 */
	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
		createCSPViolation(long cspViolationId) {

		return _cspViolationLocalService.createCSPViolation(cspViolationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cspViolationLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
		deleteCSPViolation(
			com.liferay.samples.fbo.csp.manager.model.CSPViolation
				cspViolation) {

		return _cspViolationLocalService.deleteCSPViolation(cspViolation);
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
	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
			deleteCSPViolation(long cspViolationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cspViolationLocalService.deleteCSPViolation(cspViolationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cspViolationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _cspViolationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _cspViolationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cspViolationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _cspViolationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _cspViolationLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _cspViolationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _cspViolationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _cspViolationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
		fetchCSPViolation(long cspViolationId) {

		return _cspViolationLocalService.fetchCSPViolation(cspViolationId);
	}

	/**
	 * Returns the csp violation matching the UUID and group.
	 *
	 * @param uuid the csp violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
		fetchCSPViolationByUuidAndGroupId(String uuid, long groupId) {

		return _cspViolationLocalService.fetchCSPViolationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cspViolationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the csp violation with the primary key.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation
	 * @throws PortalException if a csp violation with the primary key could not be found
	 */
	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
			getCSPViolation(long cspViolationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cspViolationLocalService.getCSPViolation(cspViolationId);
	}

	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
			getCSPViolationByPlidAndHash(long plid, String hash)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return _cspViolationLocalService.getCSPViolationByPlidAndHash(
			plid, hash);
	}

	/**
	 * Returns the csp violation matching the UUID and group.
	 *
	 * @param uuid the csp violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching csp violation
	 * @throws PortalException if a matching csp violation could not be found
	 */
	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
			getCSPViolationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cspViolationLocalService.getCSPViolationByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List
		<com.liferay.samples.fbo.csp.manager.model.CSPViolation>
			getCSPViolations(int start, int end) {

		return _cspViolationLocalService.getCSPViolations(start, end);
	}

	@Override
	public java.util.List
		<com.liferay.samples.fbo.csp.manager.model.CSPViolation>
			getCSPViolationsByPlid(long plid) {

		return _cspViolationLocalService.getCSPViolationsByPlid(plid);
	}

	/**
	 * Returns all the csp violations matching the UUID and company.
	 *
	 * @param uuid the UUID of the csp violations
	 * @param companyId the primary key of the company
	 * @return the matching csp violations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.liferay.samples.fbo.csp.manager.model.CSPViolation>
			getCSPViolationsByUuidAndCompanyId(String uuid, long companyId) {

		return _cspViolationLocalService.getCSPViolationsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List
		<com.liferay.samples.fbo.csp.manager.model.CSPViolation>
			getCSPViolationsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.samples.fbo.csp.manager.model.CSPViolation>
						orderByComparator) {

		return _cspViolationLocalService.getCSPViolationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of csp violations.
	 *
	 * @return the number of csp violations
	 */
	@Override
	public int getCSPViolationsCount() {
		return _cspViolationLocalService.getCSPViolationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _cspViolationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cspViolationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cspViolationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cspViolationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List
		<com.liferay.samples.fbo.csp.manager.model.CSPViolation>
			getWhiteListedCSPViolationsByPlid(long plid) {

		return _cspViolationLocalService.getWhiteListedCSPViolationsByPlid(
			plid);
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
	@Override
	public com.liferay.samples.fbo.csp.manager.model.CSPViolation
		updateCSPViolation(
			com.liferay.samples.fbo.csp.manager.model.CSPViolation
				cspViolation) {

		return _cspViolationLocalService.updateCSPViolation(cspViolation);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _cspViolationLocalService.getBasePersistence();
	}

	@Override
	public CSPViolationLocalService getWrappedService() {
		return _cspViolationLocalService;
	}

	@Override
	public void setWrappedService(
		CSPViolationLocalService cspViolationLocalService) {

		_cspViolationLocalService = cspViolationLocalService;
	}

	private CSPViolationLocalService _cspViolationLocalService;

}