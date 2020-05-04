/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.external.data.source.test;

import com.liferay.external.data.source.test.model.TestEntity;
import com.liferay.external.data.source.test.service.TestEntityLocalServiceUtil;
import com.liferay.external.data.source.test.service.persistence.TestEntityPersistence;
import com.liferay.external.data.source.test.service.persistence.TestEntityUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Preston Crary
 */
public class DataSourceTest {

	@Before
	public void setUp() {
		_persistence = TestEntityUtil.getPersistence();

		_dataSource = _persistence.getDataSource();
	}

	@Test
	public void testDataSource() throws Exception {
		Assert.assertNotSame(InfrastructureUtil.getDataSource(), _dataSource);
	}

	@Test
	public void testUpdate() throws Exception {
		try (Connection con = _dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"delete from TestEntity")) {

			ps.executeUpdate();
		}

		long pk = RandomTestUtil.nextLong();

		TestEntity testEntity = _persistence.create(pk);

		testEntity.setData(DataSourceTest.class.getName());

		TestEntityLocalServiceUtil.addTestEntity(testEntity);

		DataSource portalDataSource = InfrastructureUtil.getDataSource();

		try (Connection con = portalDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"select * from TestEntity");
			ResultSet rs = ps.executeQuery()) {

			Assert.assertFalse(rs.next());
		}

		try (Connection con = _dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"select * from TestEntity");
			ResultSet rs = ps.executeQuery()) {

			Assert.assertTrue(rs.next());
			Assert.assertEquals(pk, rs.getLong("id_"));
			Assert.assertEquals(
				DataSourceTest.class.getName(), rs.getString("data_"));
		}
	}

	private DataSource _dataSource;
	private TestEntityPersistence _persistence;

}