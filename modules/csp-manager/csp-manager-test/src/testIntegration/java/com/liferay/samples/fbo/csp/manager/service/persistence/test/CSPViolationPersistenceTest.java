/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.samples.fbo.csp.manager.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import com.liferay.samples.fbo.csp.manager.exception.NoSuchCSPViolationException;
import com.liferay.samples.fbo.csp.manager.model.CSPViolation;
import com.liferay.samples.fbo.csp.manager.service.CSPViolationLocalServiceUtil;
import com.liferay.samples.fbo.csp.manager.service.persistence.CSPViolationPersistence;
import com.liferay.samples.fbo.csp.manager.service.persistence.CSPViolationUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CSPViolationPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.liferay.samples.fbo.csp.manager.service"));

	@Before
	public void setUp() {
		_persistence = CSPViolationUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CSPViolation> iterator = _cspViolations.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CSPViolation cspViolation = _persistence.create(pk);

		Assert.assertNotNull(cspViolation);

		Assert.assertEquals(cspViolation.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CSPViolation newCSPViolation = addCSPViolation();

		_persistence.remove(newCSPViolation);

		CSPViolation existingCSPViolation = _persistence.fetchByPrimaryKey(
			newCSPViolation.getPrimaryKey());

		Assert.assertNull(existingCSPViolation);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCSPViolation();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CSPViolation newCSPViolation = _persistence.create(pk);

		newCSPViolation.setUuid(RandomTestUtil.randomString());

		newCSPViolation.setGroupId(RandomTestUtil.nextLong());

		newCSPViolation.setCompanyId(RandomTestUtil.nextLong());

		newCSPViolation.setUserId(RandomTestUtil.nextLong());

		newCSPViolation.setUserName(RandomTestUtil.randomString());

		newCSPViolation.setCreateDate(RandomTestUtil.nextDate());

		newCSPViolation.setModifiedDate(RandomTestUtil.nextDate());

		newCSPViolation.setPlid(RandomTestUtil.nextLong());

		newCSPViolation.setUrl(RandomTestUtil.randomString());

		newCSPViolation.setViolationType(RandomTestUtil.randomString());

		newCSPViolation.setViolation(RandomTestUtil.randomString());

		newCSPViolation.setViolationHash(RandomTestUtil.randomString());

		newCSPViolation.setWhiteListed(RandomTestUtil.randomBoolean());

		_cspViolations.add(_persistence.update(newCSPViolation));

		CSPViolation existingCSPViolation = _persistence.findByPrimaryKey(
			newCSPViolation.getPrimaryKey());

		Assert.assertEquals(
			existingCSPViolation.getUuid(), newCSPViolation.getUuid());
		Assert.assertEquals(
			existingCSPViolation.getCspViolationId(),
			newCSPViolation.getCspViolationId());
		Assert.assertEquals(
			existingCSPViolation.getGroupId(), newCSPViolation.getGroupId());
		Assert.assertEquals(
			existingCSPViolation.getCompanyId(),
			newCSPViolation.getCompanyId());
		Assert.assertEquals(
			existingCSPViolation.getUserId(), newCSPViolation.getUserId());
		Assert.assertEquals(
			existingCSPViolation.getUserName(), newCSPViolation.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCSPViolation.getCreateDate()),
			Time.getShortTimestamp(newCSPViolation.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCSPViolation.getModifiedDate()),
			Time.getShortTimestamp(newCSPViolation.getModifiedDate()));
		Assert.assertEquals(
			existingCSPViolation.getPlid(), newCSPViolation.getPlid());
		Assert.assertEquals(
			existingCSPViolation.getUrl(), newCSPViolation.getUrl());
		Assert.assertEquals(
			existingCSPViolation.getViolationType(),
			newCSPViolation.getViolationType());
		Assert.assertEquals(
			existingCSPViolation.getViolation(),
			newCSPViolation.getViolation());
		Assert.assertEquals(
			existingCSPViolation.getViolationHash(),
			newCSPViolation.getViolationHash());
		Assert.assertEquals(
			existingCSPViolation.isWhiteListed(),
			newCSPViolation.isWhiteListed());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByPlid() throws Exception {
		_persistence.countByPlid(RandomTestUtil.nextLong());

		_persistence.countByPlid(0L);
	}

	@Test
	public void testCountByPlid_WhiteListed() throws Exception {
		_persistence.countByPlid_WhiteListed(
			RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean());

		_persistence.countByPlid_WhiteListed(
			0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByPlid_Hash() throws Exception {
		_persistence.countByPlid_Hash(RandomTestUtil.nextLong(), "");

		_persistence.countByPlid_Hash(0L, "null");

		_persistence.countByPlid_Hash(0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CSPViolation newCSPViolation = addCSPViolation();

		CSPViolation existingCSPViolation = _persistence.findByPrimaryKey(
			newCSPViolation.getPrimaryKey());

		Assert.assertEquals(existingCSPViolation, newCSPViolation);
	}

	@Test(expected = NoSuchCSPViolationException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CSPViolation> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FOO_CSPViolation", "uuid", true, "cspViolationId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "plid", true, "url", true,
			"violationType", true, "violation", true, "violationHash", true,
			"whiteListed", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CSPViolation newCSPViolation = addCSPViolation();

		CSPViolation existingCSPViolation = _persistence.fetchByPrimaryKey(
			newCSPViolation.getPrimaryKey());

		Assert.assertEquals(existingCSPViolation, newCSPViolation);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CSPViolation missingCSPViolation = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCSPViolation);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CSPViolation newCSPViolation1 = addCSPViolation();
		CSPViolation newCSPViolation2 = addCSPViolation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCSPViolation1.getPrimaryKey());
		primaryKeys.add(newCSPViolation2.getPrimaryKey());

		Map<Serializable, CSPViolation> cspViolations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, cspViolations.size());
		Assert.assertEquals(
			newCSPViolation1,
			cspViolations.get(newCSPViolation1.getPrimaryKey()));
		Assert.assertEquals(
			newCSPViolation2,
			cspViolations.get(newCSPViolation2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CSPViolation> cspViolations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cspViolations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CSPViolation newCSPViolation = addCSPViolation();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCSPViolation.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CSPViolation> cspViolations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cspViolations.size());
		Assert.assertEquals(
			newCSPViolation,
			cspViolations.get(newCSPViolation.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CSPViolation> cspViolations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cspViolations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CSPViolation newCSPViolation = addCSPViolation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCSPViolation.getPrimaryKey());

		Map<Serializable, CSPViolation> cspViolations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cspViolations.size());
		Assert.assertEquals(
			newCSPViolation,
			cspViolations.get(newCSPViolation.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CSPViolationLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CSPViolation>() {

				@Override
				public void performAction(CSPViolation cspViolation) {
					Assert.assertNotNull(cspViolation);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CSPViolation newCSPViolation = addCSPViolation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CSPViolation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"cspViolationId", newCSPViolation.getCspViolationId()));

		List<CSPViolation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CSPViolation existingCSPViolation = result.get(0);

		Assert.assertEquals(existingCSPViolation, newCSPViolation);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CSPViolation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"cspViolationId", RandomTestUtil.nextLong()));

		List<CSPViolation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CSPViolation newCSPViolation = addCSPViolation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CSPViolation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("cspViolationId"));

		Object newCspViolationId = newCSPViolation.getCspViolationId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"cspViolationId", new Object[] {newCspViolationId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCspViolationId = result.get(0);

		Assert.assertEquals(existingCspViolationId, newCspViolationId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CSPViolation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("cspViolationId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"cspViolationId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CSPViolation newCSPViolation = addCSPViolation();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCSPViolation.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		CSPViolation newCSPViolation = addCSPViolation();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CSPViolation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"cspViolationId", newCSPViolation.getCspViolationId()));

		List<CSPViolation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(CSPViolation cspViolation) {
		Assert.assertEquals(
			cspViolation.getUuid(),
			ReflectionTestUtil.invoke(
				cspViolation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(cspViolation.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				cspViolation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));

		Assert.assertEquals(
			Long.valueOf(cspViolation.getPlid()),
			ReflectionTestUtil.<Long>invoke(
				cspViolation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "plid"));
		Assert.assertEquals(
			cspViolation.getViolationHash(),
			ReflectionTestUtil.invoke(
				cspViolation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "violationHash"));
	}

	protected CSPViolation addCSPViolation() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CSPViolation cspViolation = _persistence.create(pk);

		cspViolation.setUuid(RandomTestUtil.randomString());

		cspViolation.setGroupId(RandomTestUtil.nextLong());

		cspViolation.setCompanyId(RandomTestUtil.nextLong());

		cspViolation.setUserId(RandomTestUtil.nextLong());

		cspViolation.setUserName(RandomTestUtil.randomString());

		cspViolation.setCreateDate(RandomTestUtil.nextDate());

		cspViolation.setModifiedDate(RandomTestUtil.nextDate());

		cspViolation.setPlid(RandomTestUtil.nextLong());

		cspViolation.setUrl(RandomTestUtil.randomString());

		cspViolation.setViolationType(RandomTestUtil.randomString());

		cspViolation.setViolation(RandomTestUtil.randomString());

		cspViolation.setViolationHash(RandomTestUtil.randomString());

		cspViolation.setWhiteListed(RandomTestUtil.randomBoolean());

		_cspViolations.add(_persistence.update(cspViolation));

		return cspViolation;
	}

	private List<CSPViolation> _cspViolations = new ArrayList<CSPViolation>();
	private CSPViolationPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}