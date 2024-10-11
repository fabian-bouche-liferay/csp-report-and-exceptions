/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.samples.fbo.csp.manager.exception.NoSuchCSPViolationException;
import com.liferay.samples.fbo.csp.manager.model.CSPViolation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the csp violation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CSPViolationUtil
 * @generated
 */
@ProviderType
public interface CSPViolationPersistence extends BasePersistence<CSPViolation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CSPViolationUtil} to access the csp violation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the csp violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching csp violations
	 */
	public java.util.List<CSPViolation> findByUuid(String uuid);

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
	public java.util.List<CSPViolation> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CSPViolation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

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
	public java.util.List<CSPViolation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

	/**
	 * Returns the csp violations before and after the current csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param cspViolationId the primary key of the current csp violation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public CSPViolation[] findByUuid_PrevAndNext(
			long cspViolationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Removes all the csp violations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of csp violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching csp violations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the csp violation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCSPViolationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByUUID_G(String uuid, long groupId)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the csp violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the csp violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the csp violation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the csp violation that was removed
	 */
	public CSPViolation removeByUUID_G(String uuid, long groupId)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the number of csp violations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching csp violations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the csp violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching csp violations
	 */
	public java.util.List<CSPViolation> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CSPViolation> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CSPViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

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
	public java.util.List<CSPViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

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
	public CSPViolation[] findByUuid_C_PrevAndNext(
			long cspViolationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Removes all the csp violations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of csp violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching csp violations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the csp violations where plid = &#63;.
	 *
	 * @param plid the plid
	 * @return the matching csp violations
	 */
	public java.util.List<CSPViolation> findByPlid(long plid);

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
	public java.util.List<CSPViolation> findByPlid(
		long plid, int start, int end);

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
	public java.util.List<CSPViolation> findByPlid(
		long plid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

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
	public java.util.List<CSPViolation> findByPlid(
		long plid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByPlid_First(
			long plid,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByPlid_First(
		long plid,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByPlid_Last(
			long plid,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByPlid_Last(
		long plid,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

	/**
	 * Returns the csp violations before and after the current csp violation in the ordered set where plid = &#63;.
	 *
	 * @param cspViolationId the primary key of the current csp violation
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public CSPViolation[] findByPlid_PrevAndNext(
			long cspViolationId, long plid,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Removes all the csp violations where plid = &#63; from the database.
	 *
	 * @param plid the plid
	 */
	public void removeByPlid(long plid);

	/**
	 * Returns the number of csp violations where plid = &#63;.
	 *
	 * @param plid the plid
	 * @return the number of matching csp violations
	 */
	public int countByPlid(long plid);

	/**
	 * Returns all the csp violations where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @return the matching csp violations
	 */
	public java.util.List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed);

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
	public java.util.List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed, int start, int end);

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
	public java.util.List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

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
	public java.util.List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByPlid_WhiteListed_First(
			long plid, boolean whiteListed,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByPlid_WhiteListed_First(
		long plid, boolean whiteListed,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByPlid_WhiteListed_Last(
			long plid, boolean whiteListed,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByPlid_WhiteListed_Last(
		long plid, boolean whiteListed,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

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
	public CSPViolation[] findByPlid_WhiteListed_PrevAndNext(
			long cspViolationId, long plid, boolean whiteListed,
			com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
				orderByComparator)
		throws NoSuchCSPViolationException;

	/**
	 * Removes all the csp violations where plid = &#63; and whiteListed = &#63; from the database.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 */
	public void removeByPlid_WhiteListed(long plid, boolean whiteListed);

	/**
	 * Returns the number of csp violations where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @return the number of matching csp violations
	 */
	public int countByPlid_WhiteListed(long plid, boolean whiteListed);

	/**
	 * Returns the csp violation where plid = &#63; and violationHash = &#63; or throws a <code>NoSuchCSPViolationException</code> if it could not be found.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	public CSPViolation findByPlid_Hash(long plid, String violationHash)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the csp violation where plid = &#63; and violationHash = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByPlid_Hash(long plid, String violationHash);

	/**
	 * Returns the csp violation where plid = &#63; and violationHash = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	public CSPViolation fetchByPlid_Hash(
		long plid, String violationHash, boolean useFinderCache);

	/**
	 * Removes the csp violation where plid = &#63; and violationHash = &#63; from the database.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the csp violation that was removed
	 */
	public CSPViolation removeByPlid_Hash(long plid, String violationHash)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the number of csp violations where plid = &#63; and violationHash = &#63;.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the number of matching csp violations
	 */
	public int countByPlid_Hash(long plid, String violationHash);

	/**
	 * Caches the csp violation in the entity cache if it is enabled.
	 *
	 * @param cspViolation the csp violation
	 */
	public void cacheResult(CSPViolation cspViolation);

	/**
	 * Caches the csp violations in the entity cache if it is enabled.
	 *
	 * @param cspViolations the csp violations
	 */
	public void cacheResult(java.util.List<CSPViolation> cspViolations);

	/**
	 * Creates a new csp violation with the primary key. Does not add the csp violation to the database.
	 *
	 * @param cspViolationId the primary key for the new csp violation
	 * @return the new csp violation
	 */
	public CSPViolation create(long cspViolationId);

	/**
	 * Removes the csp violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation that was removed
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public CSPViolation remove(long cspViolationId)
		throws NoSuchCSPViolationException;

	public CSPViolation updateImpl(CSPViolation cspViolation);

	/**
	 * Returns the csp violation with the primary key or throws a <code>NoSuchCSPViolationException</code> if it could not be found.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	public CSPViolation findByPrimaryKey(long cspViolationId)
		throws NoSuchCSPViolationException;

	/**
	 * Returns the csp violation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation, or <code>null</code> if a csp violation with the primary key could not be found
	 */
	public CSPViolation fetchByPrimaryKey(long cspViolationId);

	/**
	 * Returns all the csp violations.
	 *
	 * @return the csp violations
	 */
	public java.util.List<CSPViolation> findAll();

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
	public java.util.List<CSPViolation> findAll(int start, int end);

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
	public java.util.List<CSPViolation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator);

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
	public java.util.List<CSPViolation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CSPViolation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the csp violations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of csp violations.
	 *
	 * @return the number of csp violations
	 */
	public int countAll();

}