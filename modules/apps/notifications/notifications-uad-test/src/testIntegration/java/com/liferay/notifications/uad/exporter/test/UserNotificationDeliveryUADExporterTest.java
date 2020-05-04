/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.notifications.uad.exporter.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.UserNotificationDelivery;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.service.UserNotificationDeliveryLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.user.associated.data.exporter.UADExporter;
import com.liferay.user.associated.data.test.util.BaseUADExporterTestCase;

import java.util.ArrayList;
import java.util.List;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Brian Wing Shun Chan
 */
@RunWith(Arquillian.class)
public class UserNotificationDeliveryUADExporterTest
	extends BaseUADExporterTestCase<UserNotificationDelivery> {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Override
	protected UserNotificationDelivery addBaseModel(long userId)
		throws Exception {

		UserNotificationDelivery userNotificationDelivery =
			_userNotificationDeliveryLocalService.addUserNotificationDelivery(
				userId, RandomTestUtil.randomString(), 0,
				UserNotificationDeliveryConstants.TYPE_WEBSITE,
				UserNotificationDeliveryConstants.TYPE_WEBSITE, false);

		_userNotificationDeliveries.add(userNotificationDelivery);

		return userNotificationDelivery;
	}

	@Override
	protected String getPrimaryKeyName() {
		return "userNotificationDeliveryId";
	}

	@Override
	protected UADExporter getUADExporter() {
		return _uadExporter;
	}

	@Inject(filter = "component.name=*.UserNotificationDeliveryUADExporter")
	private UADExporter _uadExporter;

	@DeleteAfterTestRun
	private final List<UserNotificationDelivery> _userNotificationDeliveries =
		new ArrayList<>();

	@Inject
	private UserNotificationDeliveryLocalService
		_userNotificationDeliveryLocalService;

}