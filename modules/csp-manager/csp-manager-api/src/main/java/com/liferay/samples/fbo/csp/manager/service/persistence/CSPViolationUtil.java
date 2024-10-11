/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.samples.fbo.csp.manager.model.CSPViolation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the csp violation service. This utility wraps <code>com.liferay.samples.fbo.csp.manager.service.persistence.impl.CSPViolationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CSPViolationPersistence
 * @generated
 */
public class CSPViolationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CSPViolation cspViolation) {
		getPersistence().clearCache(cspViolation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CSPViolation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CSPViolation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CSPViolation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CSPViolation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CSPViolation update(CSPViolation cspViolation) {
		return getPersistence().update(cspViolation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CSPViolation update(
		CSPViolation cspViolation, ServiceContext serviceContext) {

		return getPersistence().update(cspViolation, serviceContext);
	}

	/**
	 * Returns all the csp violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching csp violations
	 */
	public static List<CSPViolation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the csp violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @return the range of matching csp violations
	 */
	public static List<CSPViolation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the csp violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csp violations
	 */
	public static List<CSPViolation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the csp violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csp violations
	 */
	public static List<CSPViolation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByUuid_First(
			String uuid, OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByUuid_First(
		String uuid, OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByUuid_Last(
			String uuid, OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByUuid_Last(
		String uuid, OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the csp violations before and after the current csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param cspViolationId the primary key of the current csp violation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public static CSPViolation[] findByUuid_PrevAndNext(
			long cspViolationId, String uuid,
			OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByUuid_PrevAndNext(
			cspViolationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the csp violations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of csp violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching csp violations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the csp violation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCSPViolationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByUUID_G(String uuid, long groupId)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the csp violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the csp violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the csp violation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the csp violation that was removed
	 */
	public static CSPViolation removeByUUID_G(String uuid, long groupId)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of csp violations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching csp violations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the csp violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching csp violations
	 */
	public static List<CSPViolation> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the csp violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @return the range of matching csp violations
	 */
	public static List<CSPViolation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the csp violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csp violations
	 */
	public static List<CSPViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the csp violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csp violations
	 */
	public static List<CSPViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the csp violations before and after the current csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cspViolationId the primary key of the current csp violation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public static CSPViolation[] findByUuid_C_PrevAndNext(
			long cspViolationId, String uuid, long companyId,
			OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			cspViolationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the csp violations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of csp violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching csp violations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the csp violations where plid = &#63;.
	 *
	 * @param plid the plid
	 * @return the matching csp violations
	 */
	public static List<CSPViolation> findByPlid(long plid) {
		return getPersistence().findByPlid(plid);
	}

	/**
	 * Returns a range of all the csp violations where plid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param plid the plid
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @return the range of matching csp violations
	 */
	public static List<CSPViolation> findByPlid(long plid, int start, int end) {
		return getPersistence().findByPlid(plid, start, end);
	}

	/**
	 * Returns an ordered range of all the csp violations where plid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param plid the plid
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csp violations
	 */
	public static List<CSPViolation> findByPlid(
		long plid, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().findByPlid(plid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the csp violations where plid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param plid the plid
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csp violations
	 */
	public static List<CSPViolation> findByPlid(
		long plid, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPlid(
			plid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByPlid_First(
			long plid, OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByPlid_First(plid, orderByComparator);
	}

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByPlid_First(
		long plid, OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().fetchByPlid_First(plid, orderByComparator);
	}

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByPlid_Last(
			long plid, OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByPlid_Last(plid, orderByComparator);
	}

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByPlid_Last(
		long plid, OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().fetchByPlid_Last(plid, orderByComparator);
	}

	/**
	 * Returns the csp violations before and after the current csp violation in the ordered set where plid = &#63;.
	 *
	 * @param cspViolationId the primary key of the current csp violation
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public static CSPViolation[] findByPlid_PrevAndNext(
			long cspViolationId, long plid,
			OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByPlid_PrevAndNext(
			cspViolationId, plid, orderByComparator);
	}

	/**
	 * Removes all the csp violations where plid = &#63; from the database.
	 *
	 * @param plid the plid
	 */
	public static void removeByPlid(long plid) {
		getPersistence().removeByPlid(plid);
	}

	/**
	 * Returns the number of csp violations where plid = &#63;.
	 *
	 * @param plid the plid
	 * @return the number of matching csp violations
	 */
	public static int countByPlid(long plid) {
		return getPersistence().countByPlid(plid);
	}

	/**
	 * Returns all the csp violations where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @return the matching csp violations
	 */
	public static List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed) {

		return getPersistence().findByPlid_WhiteListed(plid, whiteListed);
	}

	/**
	 * Returns a range of all the csp violations where plid = &#63; and whiteListed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @return the range of matching csp violations
	 */
	public static List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed, int start, int end) {

		return getPersistence().findByPlid_WhiteListed(
			plid, whiteListed, start, end);
	}

	/**
	 * Returns an ordered range of all the csp violations where plid = &#63; and whiteListed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csp violations
	 */
	public static List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().findByPlid_WhiteListed(
			plid, whiteListed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the csp violations where plid = &#63; and whiteListed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csp violations
	 */
	public static List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPlid_WhiteListed(
			plid, whiteListed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByPlid_WhiteListed_First(
			long plid, boolean whiteListed,
			OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByPlid_WhiteListed_First(
			plid, whiteListed, orderByComparator);
	}

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByPlid_WhiteListed_First(
		long plid, boolean whiteListed,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().fetchByPlid_WhiteListed_First(
			plid, whiteListed, orderByComparator);
	}

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByPlid_WhiteListed_Last(
			long plid, boolean whiteListed,
			OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByPlid_WhiteListed_Last(
			plid, whiteListed, orderByComparator);
	}

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByPlid_WhiteListed_Last(
		long plid, boolean whiteListed,
		OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().fetchByPlid_WhiteListed_Last(
			plid, whiteListed, orderByComparator);
	}

	/**
	 * Returns the csp violations before and after the current csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param cspViolationId the primary key of the current csp violation
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public static CSPViolation[] findByPlid_WhiteListed_PrevAndNext(
			long cspViolationId, long plid, boolean whiteListed,
			OrderByComparator<CSPViolation> orderByComparator)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByPlid_WhiteListed_PrevAndNext(
			cspViolationId, plid, whiteListed, orderByComparator);
	}

	/**
	 * Removes all the csp violations where plid = &#63; and whiteListed = &#63; from the database.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 */
	public static void removeByPlid_WhiteListed(
		long plid, boolean whiteListed) {

		getPersistence().removeByPlid_WhiteListed(plid, whiteListed);
	}

	/**
	 * Returns the number of csp violations where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @return the number of matching csp violations
	 */
	public static int countByPlid_WhiteListed(long plid, boolean whiteListed) {
		return getPersistence().countByPlid_WhiteListed(plid, whiteListed);
	}

	/**
	 * Returns the csp violation where plid = &#63; and violationHash = &#63; or throws a <code>NoSuchCSPViolationException</code> if it could not be found.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public static CSPViolation findByPlid_Hash(long plid, String violationHash)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByPlid_Hash(plid, violationHash);
	}

	/**
	 * Returns the csp violation where plid = &#63; and violationHash = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByPlid_Hash(
		long plid, String violationHash) {

		return getPersistence().fetchByPlid_Hash(plid, violationHash);
	}

	/**
	 * Returns the csp violation where plid = &#63; and violationHash = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public static CSPViolation fetchByPlid_Hash(
		long plid, String violationHash, boolean useFinderCache) {

		return getPersistence().fetchByPlid_Hash(
			plid, violationHash, useFinderCache);
	}

	/**
	 * Removes the csp violation where plid = &#63; and violationHash = &#63; from the database.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the csp violation that was removed
	 */
	public static CSPViolation removeByPlid_Hash(
			long plid, String violationHash)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().removeByPlid_Hash(plid, violationHash);
	}

	/**
	 * Returns the number of csp violations where plid = &#63; and violationHash = &#63;.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the number of matching csp violations
	 */
	public static int countByPlid_Hash(long plid, String violationHash) {
		return getPersistence().countByPlid_Hash(plid, violationHash);
	}

	/**
	 * Caches the csp violation in the entity cache if it is enabled.
	 *
	 * @param cspViolation the csp violation
	 */
	public static void cacheResult(CSPViolation cspViolation) {
		getPersistence().cacheResult(cspViolation);
	}

	/**
	 * Caches the csp violations in the entity cache if it is enabled.
	 *
	 * @param cspViolations the csp violations
	 */
	public static void cacheResult(List<CSPViolation> cspViolations) {
		getPersistence().cacheResult(cspViolations);
	}

	/**
	 * Creates a new csp violation with the primary key. Does not add the csp violation to the database.
	 *
	 * @param cspViolationId the primary key for the new csp violation
	 * @return the new csp violation
	 */
	public static CSPViolation create(long cspViolationId) {
		return getPersistence().create(cspViolationId);
	}

	/**
	 * Removes the csp violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation that was removed
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public static CSPViolation remove(long cspViolationId)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().remove(cspViolationId);
	}

	public static CSPViolation updateImpl(CSPViolation cspViolation) {
		return getPersistence().updateImpl(cspViolation);
	}

	/**
	 * Returns the csp violation with the primary key or throws a <code>NoSuchCSPViolationException</code> if it could not be found.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public static CSPViolation findByPrimaryKey(long cspViolationId)
		throws com.liferay.samples.fbo.csp.manager.exception.
			NoSuchCSPViolationException {

		return getPersistence().findByPrimaryKey(cspViolationId);
	}

	/**
	 * Returns the csp violation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation, or <code>null</code> if a csp violation with the primary key could not be found
	 */
	public static CSPViolation fetchByPrimaryKey(long cspViolationId) {
		return getPersistence().fetchByPrimaryKey(cspViolationId);
	}

	/**
	 * Returns all the csp violations.
	 *
	 * @return the csp violations
	 */
	public static List<CSPViolation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the csp violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @return the range of csp violations
	 */
	public static List<CSPViolation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the csp violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of csp violations
	 */
	public static List<CSPViolation> findAll(
		int start, int end, OrderByComparator<CSPViolation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the csp violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CSPViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of csp violations
	 * @param end the upper bound of the range of csp violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of csp violations
	 */
	public static List<CSPViolation> findAll(
		int start, int end, OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the csp violations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of csp violations.
	 *
	 * @return the number of csp violations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CSPViolationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CSPViolationPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CSPViolationPersistence _persistence;

}