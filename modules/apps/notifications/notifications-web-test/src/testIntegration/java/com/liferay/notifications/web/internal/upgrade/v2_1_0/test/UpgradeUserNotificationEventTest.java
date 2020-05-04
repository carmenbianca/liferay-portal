/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.notifications.web.internal.upgrade.v2_1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.db.DBInspector;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sergio González
 */
@RunWith(Arquillian.class)
public class UpgradeUserNotificationEventTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testColumnExists() throws Exception {
		try (Connection con = DataAccess.getConnection()) {
			DBInspector dbInspector = new DBInspector(con);

			Assert.assertTrue(dbInspector.hasTable("UserNotificationEvent"));

			Assert.assertTrue(
				dbInspector.hasColumn(
					"UserNotificationEvent", "actionRequired"));
			Assert.assertTrue(
				dbInspector.hasColumn("UserNotificationEvent", "delivered"));
			Assert.assertTrue(
				dbInspector.hasColumn("UserNotificationEvent", "deliveryType"));
			Assert.assertTrue(
				dbInspector.hasColumn("UserNotificationEvent", "payload"));
			Assert.assertTrue(
				dbInspector.hasColumn(
					"UserNotificationEvent", "userNotificationEventId"));
		}
	}

}