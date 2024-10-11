/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.samples.fbo.csp.manager.exception.NoSuchCSPViolationException;
import com.liferay.samples.fbo.csp.manager.model.CSPViolation;
import com.liferay.samples.fbo.csp.manager.model.CSPViolationTable;
import com.liferay.samples.fbo.csp.manager.model.impl.CSPViolationImpl;
import com.liferay.samples.fbo.csp.manager.model.impl.CSPViolationModelImpl;
import com.liferay.samples.fbo.csp.manager.service.persistence.CSPViolationPersistence;
import com.liferay.samples.fbo.csp.manager.service.persistence.CSPViolationUtil;
import com.liferay.samples.fbo.csp.manager.service.persistence.impl.constants.FOOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the csp violation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CSPViolationPersistence.class)
public class CSPViolationPersistenceImpl
	extends BasePersistenceImpl<CSPViolation>
	implements CSPViolationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CSPViolationUtil</code> to access the csp violation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CSPViolationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the csp violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching csp violations
	 */
	@Override
	public List<CSPViolation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CSPViolation> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CSPViolation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CSPViolation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CSPViolation> list = null;

		if (useFinderCache) {
			list = (List<CSPViolation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CSPViolation cspViolation : list) {
					if (!uuid.equals(cspViolation.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CSPViolationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CSPViolation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation findByUuid_First(
			String uuid, OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByUuid_First(uuid, orderByComparator);

		if (cspViolation != null) {
			return cspViolation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCSPViolationException(sb.toString());
	}

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByUuid_First(
		String uuid, OrderByComparator<CSPViolation> orderByComparator) {

		List<CSPViolation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation findByUuid_Last(
			String uuid, OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByUuid_Last(uuid, orderByComparator);

		if (cspViolation != null) {
			return cspViolation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCSPViolationException(sb.toString());
	}

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByUuid_Last(
		String uuid, OrderByComparator<CSPViolation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CSPViolation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CSPViolation[] findByUuid_PrevAndNext(
			long cspViolationId, String uuid,
			OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		uuid = Objects.toString(uuid, "");

		CSPViolation cspViolation = findByPrimaryKey(cspViolationId);

		Session session = null;

		try {
			session = openSession();

			CSPViolation[] array = new CSPViolationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, cspViolation, uuid, orderByComparator, true);

			array[1] = cspViolation;

			array[2] = getByUuid_PrevAndNext(
				session, cspViolation, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CSPViolation getByUuid_PrevAndNext(
		Session session, CSPViolation cspViolation, String uuid,
		OrderByComparator<CSPViolation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CSPViolationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cspViolation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CSPViolation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csp violations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CSPViolation cspViolation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cspViolation);
		}
	}

	/**
	 * Returns the number of csp violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching csp violations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSPVIOLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"cspViolation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(cspViolation.uuid IS NULL OR cspViolation.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the csp violation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCSPViolationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation findByUUID_G(String uuid, long groupId)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByUUID_G(uuid, groupId);

		if (cspViolation == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCSPViolationException(sb.toString());
		}

		return cspViolation;
	}

	/**
	 * Returns the csp violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the csp violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof CSPViolation) {
			CSPViolation cspViolation = (CSPViolation)result;

			if (!Objects.equals(uuid, cspViolation.getUuid()) ||
				(groupId != cspViolation.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<CSPViolation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CSPViolation cspViolation = list.get(0);

					result = cspViolation;

					cacheResult(cspViolation);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CSPViolation)result;
		}
	}

	/**
	 * Removes the csp violation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the csp violation that was removed
	 */
	@Override
	public CSPViolation removeByUUID_G(String uuid, long groupId)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = findByUUID_G(uuid, groupId);

		return remove(cspViolation);
	}

	/**
	 * Returns the number of csp violations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching csp violations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSPVIOLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"cspViolation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(cspViolation.uuid IS NULL OR cspViolation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"cspViolation.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the csp violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching csp violations
	 */
	@Override
	public List<CSPViolation> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CSPViolation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CSPViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CSPViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CSPViolation> list = null;

		if (useFinderCache) {
			list = (List<CSPViolation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CSPViolation cspViolation : list) {
					if (!uuid.equals(cspViolation.getUuid()) ||
						(companyId != cspViolation.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CSPViolationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<CSPViolation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CSPViolation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (cspViolation != null) {
			return cspViolation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCSPViolationException(sb.toString());
	}

	/**
	 * Returns the first csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CSPViolation> orderByComparator) {

		List<CSPViolation> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CSPViolation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (cspViolation != null) {
			return cspViolation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCSPViolationException(sb.toString());
	}

	/**
	 * Returns the last csp violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CSPViolation> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CSPViolation> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CSPViolation[] findByUuid_C_PrevAndNext(
			long cspViolationId, String uuid, long companyId,
			OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		uuid = Objects.toString(uuid, "");

		CSPViolation cspViolation = findByPrimaryKey(cspViolationId);

		Session session = null;

		try {
			session = openSession();

			CSPViolation[] array = new CSPViolationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, cspViolation, uuid, companyId, orderByComparator,
				true);

			array[1] = cspViolation;

			array[2] = getByUuid_C_PrevAndNext(
				session, cspViolation, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CSPViolation getByUuid_C_PrevAndNext(
		Session session, CSPViolation cspViolation, String uuid, long companyId,
		OrderByComparator<CSPViolation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CSPViolationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cspViolation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CSPViolation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csp violations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CSPViolation cspViolation :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cspViolation);
		}
	}

	/**
	 * Returns the number of csp violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching csp violations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSPVIOLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"cspViolation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(cspViolation.uuid IS NULL OR cspViolation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"cspViolation.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPlid;
	private FinderPath _finderPathWithoutPaginationFindByPlid;
	private FinderPath _finderPathCountByPlid;

	/**
	 * Returns all the csp violations where plid = &#63;.
	 *
	 * @param plid the plid
	 * @return the matching csp violations
	 */
	@Override
	public List<CSPViolation> findByPlid(long plid) {
		return findByPlid(plid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CSPViolation> findByPlid(long plid, int start, int end) {
		return findByPlid(plid, start, end, null);
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
	@Override
	public List<CSPViolation> findByPlid(
		long plid, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return findByPlid(plid, start, end, orderByComparator, true);
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
	@Override
	public List<CSPViolation> findByPlid(
		long plid, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPlid;
				finderArgs = new Object[] {plid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPlid;
			finderArgs = new Object[] {plid, start, end, orderByComparator};
		}

		List<CSPViolation> list = null;

		if (useFinderCache) {
			list = (List<CSPViolation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CSPViolation cspViolation : list) {
					if (plid != cspViolation.getPlid()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_PLID_PLID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CSPViolationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(plid);

				list = (List<CSPViolation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation findByPlid_First(
			long plid, OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByPlid_First(plid, orderByComparator);

		if (cspViolation != null) {
			return cspViolation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("plid=");
		sb.append(plid);

		sb.append("}");

		throw new NoSuchCSPViolationException(sb.toString());
	}

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByPlid_First(
		long plid, OrderByComparator<CSPViolation> orderByComparator) {

		List<CSPViolation> list = findByPlid(plid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation findByPlid_Last(
			long plid, OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByPlid_Last(plid, orderByComparator);

		if (cspViolation != null) {
			return cspViolation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("plid=");
		sb.append(plid);

		sb.append("}");

		throw new NoSuchCSPViolationException(sb.toString());
	}

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63;.
	 *
	 * @param plid the plid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByPlid_Last(
		long plid, OrderByComparator<CSPViolation> orderByComparator) {

		int count = countByPlid(plid);

		if (count == 0) {
			return null;
		}

		List<CSPViolation> list = findByPlid(
			plid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CSPViolation[] findByPlid_PrevAndNext(
			long cspViolationId, long plid,
			OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = findByPrimaryKey(cspViolationId);

		Session session = null;

		try {
			session = openSession();

			CSPViolation[] array = new CSPViolationImpl[3];

			array[0] = getByPlid_PrevAndNext(
				session, cspViolation, plid, orderByComparator, true);

			array[1] = cspViolation;

			array[2] = getByPlid_PrevAndNext(
				session, cspViolation, plid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CSPViolation getByPlid_PrevAndNext(
		Session session, CSPViolation cspViolation, long plid,
		OrderByComparator<CSPViolation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

		sb.append(_FINDER_COLUMN_PLID_PLID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CSPViolationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(plid);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cspViolation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CSPViolation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csp violations where plid = &#63; from the database.
	 *
	 * @param plid the plid
	 */
	@Override
	public void removeByPlid(long plid) {
		for (CSPViolation cspViolation :
				findByPlid(plid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cspViolation);
		}
	}

	/**
	 * Returns the number of csp violations where plid = &#63;.
	 *
	 * @param plid the plid
	 * @return the number of matching csp violations
	 */
	@Override
	public int countByPlid(long plid) {
		FinderPath finderPath = _finderPathCountByPlid;

		Object[] finderArgs = new Object[] {plid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSPVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_PLID_PLID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(plid);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PLID_PLID_2 =
		"cspViolation.plid = ?";

	private FinderPath _finderPathWithPaginationFindByPlid_WhiteListed;
	private FinderPath _finderPathWithoutPaginationFindByPlid_WhiteListed;
	private FinderPath _finderPathCountByPlid_WhiteListed;

	/**
	 * Returns all the csp violations where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @return the matching csp violations
	 */
	@Override
	public List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed) {

		return findByPlid_WhiteListed(
			plid, whiteListed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed, int start, int end) {

		return findByPlid_WhiteListed(plid, whiteListed, start, end, null);
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
	@Override
	public List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator) {

		return findByPlid_WhiteListed(
			plid, whiteListed, start, end, orderByComparator, true);
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
	@Override
	public List<CSPViolation> findByPlid_WhiteListed(
		long plid, boolean whiteListed, int start, int end,
		OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPlid_WhiteListed;
				finderArgs = new Object[] {plid, whiteListed};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPlid_WhiteListed;
			finderArgs = new Object[] {
				plid, whiteListed, start, end, orderByComparator
			};
		}

		List<CSPViolation> list = null;

		if (useFinderCache) {
			list = (List<CSPViolation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CSPViolation cspViolation : list) {
					if ((plid != cspViolation.getPlid()) ||
						(whiteListed != cspViolation.isWhiteListed())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_PLID_WHITELISTED_PLID_2);

			sb.append(_FINDER_COLUMN_PLID_WHITELISTED_WHITELISTED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CSPViolationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(plid);

				queryPos.add(whiteListed);

				list = (List<CSPViolation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CSPViolation findByPlid_WhiteListed_First(
			long plid, boolean whiteListed,
			OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByPlid_WhiteListed_First(
			plid, whiteListed, orderByComparator);

		if (cspViolation != null) {
			return cspViolation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("plid=");
		sb.append(plid);

		sb.append(", whiteListed=");
		sb.append(whiteListed);

		sb.append("}");

		throw new NoSuchCSPViolationException(sb.toString());
	}

	/**
	 * Returns the first csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByPlid_WhiteListed_First(
		long plid, boolean whiteListed,
		OrderByComparator<CSPViolation> orderByComparator) {

		List<CSPViolation> list = findByPlid_WhiteListed(
			plid, whiteListed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CSPViolation findByPlid_WhiteListed_Last(
			long plid, boolean whiteListed,
			OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByPlid_WhiteListed_Last(
			plid, whiteListed, orderByComparator);

		if (cspViolation != null) {
			return cspViolation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("plid=");
		sb.append(plid);

		sb.append(", whiteListed=");
		sb.append(whiteListed);

		sb.append("}");

		throw new NoSuchCSPViolationException(sb.toString());
	}

	/**
	 * Returns the last csp violation in the ordered set where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByPlid_WhiteListed_Last(
		long plid, boolean whiteListed,
		OrderByComparator<CSPViolation> orderByComparator) {

		int count = countByPlid_WhiteListed(plid, whiteListed);

		if (count == 0) {
			return null;
		}

		List<CSPViolation> list = findByPlid_WhiteListed(
			plid, whiteListed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CSPViolation[] findByPlid_WhiteListed_PrevAndNext(
			long cspViolationId, long plid, boolean whiteListed,
			OrderByComparator<CSPViolation> orderByComparator)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = findByPrimaryKey(cspViolationId);

		Session session = null;

		try {
			session = openSession();

			CSPViolation[] array = new CSPViolationImpl[3];

			array[0] = getByPlid_WhiteListed_PrevAndNext(
				session, cspViolation, plid, whiteListed, orderByComparator,
				true);

			array[1] = cspViolation;

			array[2] = getByPlid_WhiteListed_PrevAndNext(
				session, cspViolation, plid, whiteListed, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CSPViolation getByPlid_WhiteListed_PrevAndNext(
		Session session, CSPViolation cspViolation, long plid,
		boolean whiteListed, OrderByComparator<CSPViolation> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

		sb.append(_FINDER_COLUMN_PLID_WHITELISTED_PLID_2);

		sb.append(_FINDER_COLUMN_PLID_WHITELISTED_WHITELISTED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CSPViolationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(plid);

		queryPos.add(whiteListed);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cspViolation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CSPViolation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csp violations where plid = &#63; and whiteListed = &#63; from the database.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 */
	@Override
	public void removeByPlid_WhiteListed(long plid, boolean whiteListed) {
		for (CSPViolation cspViolation :
				findByPlid_WhiteListed(
					plid, whiteListed, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(cspViolation);
		}
	}

	/**
	 * Returns the number of csp violations where plid = &#63; and whiteListed = &#63;.
	 *
	 * @param plid the plid
	 * @param whiteListed the white listed
	 * @return the number of matching csp violations
	 */
	@Override
	public int countByPlid_WhiteListed(long plid, boolean whiteListed) {
		FinderPath finderPath = _finderPathCountByPlid_WhiteListed;

		Object[] finderArgs = new Object[] {plid, whiteListed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSPVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_PLID_WHITELISTED_PLID_2);

			sb.append(_FINDER_COLUMN_PLID_WHITELISTED_WHITELISTED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(plid);

				queryPos.add(whiteListed);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PLID_WHITELISTED_PLID_2 =
		"cspViolation.plid = ? AND ";

	private static final String _FINDER_COLUMN_PLID_WHITELISTED_WHITELISTED_2 =
		"cspViolation.whiteListed = ?";

	private FinderPath _finderPathFetchByPlid_Hash;
	private FinderPath _finderPathCountByPlid_Hash;

	/**
	 * Returns the csp violation where plid = &#63; and violationHash = &#63; or throws a <code>NoSuchCSPViolationException</code> if it could not be found.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the matching csp violation
	 * @throws NoSuchCSPViolationException if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation findByPlid_Hash(long plid, String violationHash)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByPlid_Hash(plid, violationHash);

		if (cspViolation == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("plid=");
			sb.append(plid);

			sb.append(", violationHash=");
			sb.append(violationHash);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCSPViolationException(sb.toString());
		}

		return cspViolation;
	}

	/**
	 * Returns the csp violation where plid = &#63; and violationHash = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByPlid_Hash(long plid, String violationHash) {
		return fetchByPlid_Hash(plid, violationHash, true);
	}

	/**
	 * Returns the csp violation where plid = &#63; and violationHash = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching csp violation, or <code>null</code> if a matching csp violation could not be found
	 */
	@Override
	public CSPViolation fetchByPlid_Hash(
		long plid, String violationHash, boolean useFinderCache) {

		violationHash = Objects.toString(violationHash, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {plid, violationHash};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPlid_Hash, finderArgs, this);
		}

		if (result instanceof CSPViolation) {
			CSPViolation cspViolation = (CSPViolation)result;

			if ((plid != cspViolation.getPlid()) ||
				!Objects.equals(
					violationHash, cspViolation.getViolationHash())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CSPVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_PLID_HASH_PLID_2);

			boolean bindViolationHash = false;

			if (violationHash.isEmpty()) {
				sb.append(_FINDER_COLUMN_PLID_HASH_VIOLATIONHASH_3);
			}
			else {
				bindViolationHash = true;

				sb.append(_FINDER_COLUMN_PLID_HASH_VIOLATIONHASH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(plid);

				if (bindViolationHash) {
					queryPos.add(violationHash);
				}

				List<CSPViolation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPlid_Hash, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {plid, violationHash};
							}

							_log.warn(
								"CSPViolationPersistenceImpl.fetchByPlid_Hash(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CSPViolation cspViolation = list.get(0);

					result = cspViolation;

					cacheResult(cspViolation);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CSPViolation)result;
		}
	}

	/**
	 * Removes the csp violation where plid = &#63; and violationHash = &#63; from the database.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the csp violation that was removed
	 */
	@Override
	public CSPViolation removeByPlid_Hash(long plid, String violationHash)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = findByPlid_Hash(plid, violationHash);

		return remove(cspViolation);
	}

	/**
	 * Returns the number of csp violations where plid = &#63; and violationHash = &#63;.
	 *
	 * @param plid the plid
	 * @param violationHash the violation hash
	 * @return the number of matching csp violations
	 */
	@Override
	public int countByPlid_Hash(long plid, String violationHash) {
		violationHash = Objects.toString(violationHash, "");

		FinderPath finderPath = _finderPathCountByPlid_Hash;

		Object[] finderArgs = new Object[] {plid, violationHash};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSPVIOLATION_WHERE);

			sb.append(_FINDER_COLUMN_PLID_HASH_PLID_2);

			boolean bindViolationHash = false;

			if (violationHash.isEmpty()) {
				sb.append(_FINDER_COLUMN_PLID_HASH_VIOLATIONHASH_3);
			}
			else {
				bindViolationHash = true;

				sb.append(_FINDER_COLUMN_PLID_HASH_VIOLATIONHASH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(plid);

				if (bindViolationHash) {
					queryPos.add(violationHash);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PLID_HASH_PLID_2 =
		"cspViolation.plid = ? AND ";

	private static final String _FINDER_COLUMN_PLID_HASH_VIOLATIONHASH_2 =
		"cspViolation.violationHash = ?";

	private static final String _FINDER_COLUMN_PLID_HASH_VIOLATIONHASH_3 =
		"(cspViolation.violationHash IS NULL OR cspViolation.violationHash = '')";

	public CSPViolationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CSPViolation.class);

		setModelImplClass(CSPViolationImpl.class);
		setModelPKClass(long.class);

		setTable(CSPViolationTable.INSTANCE);
	}

	/**
	 * Caches the csp violation in the entity cache if it is enabled.
	 *
	 * @param cspViolation the csp violation
	 */
	@Override
	public void cacheResult(CSPViolation cspViolation) {
		entityCache.putResult(
			CSPViolationImpl.class, cspViolation.getPrimaryKey(), cspViolation);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {cspViolation.getUuid(), cspViolation.getGroupId()},
			cspViolation);

		finderCache.putResult(
			_finderPathFetchByPlid_Hash,
			new Object[] {
				cspViolation.getPlid(), cspViolation.getViolationHash()
			},
			cspViolation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the csp violations in the entity cache if it is enabled.
	 *
	 * @param cspViolations the csp violations
	 */
	@Override
	public void cacheResult(List<CSPViolation> cspViolations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cspViolations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CSPViolation cspViolation : cspViolations) {
			if (entityCache.getResult(
					CSPViolationImpl.class, cspViolation.getPrimaryKey()) ==
						null) {

				cacheResult(cspViolation);
			}
		}
	}

	/**
	 * Clears the cache for all csp violations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CSPViolationImpl.class);

		finderCache.clearCache(CSPViolationImpl.class);
	}

	/**
	 * Clears the cache for the csp violation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CSPViolation cspViolation) {
		entityCache.removeResult(CSPViolationImpl.class, cspViolation);
	}

	@Override
	public void clearCache(List<CSPViolation> cspViolations) {
		for (CSPViolation cspViolation : cspViolations) {
			entityCache.removeResult(CSPViolationImpl.class, cspViolation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CSPViolationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CSPViolationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CSPViolationModelImpl cspViolationModelImpl) {

		Object[] args = new Object[] {
			cspViolationModelImpl.getUuid(), cspViolationModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, cspViolationModelImpl);

		args = new Object[] {
			cspViolationModelImpl.getPlid(),
			cspViolationModelImpl.getViolationHash()
		};

		finderCache.putResult(
			_finderPathCountByPlid_Hash, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByPlid_Hash, args, cspViolationModelImpl);
	}

	/**
	 * Creates a new csp violation with the primary key. Does not add the csp violation to the database.
	 *
	 * @param cspViolationId the primary key for the new csp violation
	 * @return the new csp violation
	 */
	@Override
	public CSPViolation create(long cspViolationId) {
		CSPViolation cspViolation = new CSPViolationImpl();

		cspViolation.setNew(true);
		cspViolation.setPrimaryKey(cspViolationId);

		String uuid = PortalUUIDUtil.generate();

		cspViolation.setUuid(uuid);

		cspViolation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return cspViolation;
	}

	/**
	 * Removes the csp violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation that was removed
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	@Override
	public CSPViolation remove(long cspViolationId)
		throws NoSuchCSPViolationException {

		return remove((Serializable)cspViolationId);
	}

	/**
	 * Removes the csp violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the csp violation
	 * @return the csp violation that was removed
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	@Override
	public CSPViolation remove(Serializable primaryKey)
		throws NoSuchCSPViolationException {

		Session session = null;

		try {
			session = openSession();

			CSPViolation cspViolation = (CSPViolation)session.get(
				CSPViolationImpl.class, primaryKey);

			if (cspViolation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCSPViolationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cspViolation);
		}
		catch (NoSuchCSPViolationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CSPViolation removeImpl(CSPViolation cspViolation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cspViolation)) {
				cspViolation = (CSPViolation)session.get(
					CSPViolationImpl.class, cspViolation.getPrimaryKeyObj());
			}

			if (cspViolation != null) {
				session.delete(cspViolation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cspViolation != null) {
			clearCache(cspViolation);
		}

		return cspViolation;
	}

	@Override
	public CSPViolation updateImpl(CSPViolation cspViolation) {
		boolean isNew = cspViolation.isNew();

		if (!(cspViolation instanceof CSPViolationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cspViolation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					cspViolation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cspViolation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CSPViolation implementation " +
					cspViolation.getClass());
		}

		CSPViolationModelImpl cspViolationModelImpl =
			(CSPViolationModelImpl)cspViolation;

		if (Validator.isNull(cspViolation.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			cspViolation.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (cspViolation.getCreateDate() == null)) {
			if (serviceContext == null) {
				cspViolation.setCreateDate(date);
			}
			else {
				cspViolation.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!cspViolationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cspViolation.setModifiedDate(date);
			}
			else {
				cspViolation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cspViolation);
			}
			else {
				cspViolation = (CSPViolation)session.merge(cspViolation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CSPViolationImpl.class, cspViolationModelImpl, false, true);

		cacheUniqueFindersCache(cspViolationModelImpl);

		if (isNew) {
			cspViolation.setNew(false);
		}

		cspViolation.resetOriginalValues();

		return cspViolation;
	}

	/**
	 * Returns the csp violation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the csp violation
	 * @return the csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	@Override
	public CSPViolation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCSPViolationException {

		CSPViolation cspViolation = fetchByPrimaryKey(primaryKey);

		if (cspViolation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCSPViolationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cspViolation;
	}

	/**
	 * Returns the csp violation with the primary key or throws a <code>NoSuchCSPViolationException</code> if it could not be found.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation
	 * @throws NoSuchCSPViolationException if a csp violation with the primary key could not be found
	 */
	@Override
	public CSPViolation findByPrimaryKey(long cspViolationId)
		throws NoSuchCSPViolationException {

		return findByPrimaryKey((Serializable)cspViolationId);
	}

	/**
	 * Returns the csp violation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cspViolationId the primary key of the csp violation
	 * @return the csp violation, or <code>null</code> if a csp violation with the primary key could not be found
	 */
	@Override
	public CSPViolation fetchByPrimaryKey(long cspViolationId) {
		return fetchByPrimaryKey((Serializable)cspViolationId);
	}

	/**
	 * Returns all the csp violations.
	 *
	 * @return the csp violations
	 */
	@Override
	public List<CSPViolation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CSPViolation> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CSPViolation> findAll(
		int start, int end, OrderByComparator<CSPViolation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CSPViolation> findAll(
		int start, int end, OrderByComparator<CSPViolation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CSPViolation> list = null;

		if (useFinderCache) {
			list = (List<CSPViolation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CSPVIOLATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CSPVIOLATION;

				sql = sql.concat(CSPViolationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CSPViolation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the csp violations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CSPViolation cspViolation : findAll()) {
			remove(cspViolation);
		}
	}

	/**
	 * Returns the number of csp violations.
	 *
	 * @return the number of csp violations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CSPVIOLATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "cspViolationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSPVIOLATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CSPViolationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the csp violation persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByPlid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPlid",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"plid"}, true);

		_finderPathWithoutPaginationFindByPlid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPlid",
			new String[] {Long.class.getName()}, new String[] {"plid"}, true);

		_finderPathCountByPlid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPlid",
			new String[] {Long.class.getName()}, new String[] {"plid"}, false);

		_finderPathWithPaginationFindByPlid_WhiteListed = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPlid_WhiteListed",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"plid", "whiteListed"}, true);

		_finderPathWithoutPaginationFindByPlid_WhiteListed = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPlid_WhiteListed",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"plid", "whiteListed"}, true);

		_finderPathCountByPlid_WhiteListed = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPlid_WhiteListed",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"plid", "whiteListed"}, false);

		_finderPathFetchByPlid_Hash = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPlid_Hash",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"plid", "violationHash"}, true);

		_finderPathCountByPlid_Hash = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPlid_Hash",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"plid", "violationHash"}, false);

		CSPViolationUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CSPViolationUtil.setPersistence(null);

		entityCache.removeCache(CSPViolationImpl.class.getName());
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CSPVIOLATION =
		"SELECT cspViolation FROM CSPViolation cspViolation";

	private static final String _SQL_SELECT_CSPVIOLATION_WHERE =
		"SELECT cspViolation FROM CSPViolation cspViolation WHERE ";

	private static final String _SQL_COUNT_CSPVIOLATION =
		"SELECT COUNT(cspViolation) FROM CSPViolation cspViolation";

	private static final String _SQL_COUNT_CSPVIOLATION_WHERE =
		"SELECT COUNT(cspViolation) FROM CSPViolation cspViolation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cspViolation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CSPViolation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CSPViolation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CSPViolationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}