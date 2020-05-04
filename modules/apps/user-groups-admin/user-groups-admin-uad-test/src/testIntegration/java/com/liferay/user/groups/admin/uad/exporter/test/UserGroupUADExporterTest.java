/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.groups.admin.uad.exporter.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.user.associated.data.exporter.UADExporter;
import com.liferay.user.associated.data.test.util.BaseUADExporterTestCase;
import com.liferay.user.groups.admin.uad.test.UserGroupUADTestHelper;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Brian Wing Shun Chan
 */
@RunWith(Arquillian.class)
public class UserGroupUADExporterTest
	extends BaseUADExporterTestCase<UserGroup> {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@After
	public void tearDown() throws Exception {
		_userGroupUADTestHelper.cleanUpDependencies(_userGroups);
	}

	@Test
	public void testExportModelWithCDATASyntax() throws Exception {
		UserGroup userGroup = _userGroupUADTestHelper.addUserGroup(
			user.getUserId());

		userGroup.setUserName("UserGroup]]>UserName");

		_userGroups.add(userGroup);

		_uadExporter.export(userGroup);
	}

	@Override
	protected UserGroup addBaseModel(long userId) throws Exception {
		UserGroup userGroup = _userGroupUADTestHelper.addUserGroup(userId);

		_userGroups.add(userGroup);

		return userGroup;
	}

	@Override
	protected String getPrimaryKeyName() {
		return "userGroupId";
	}

	@Override
	protected UADExporter getUADExporter() {
		return _uadExporter;
	}

	@Inject(filter = "component.name=*.UserGroupUADExporter")
	private UADExporter _uadExporter;

	@DeleteAfterTestRun
	private final List<UserGroup> _userGroups = new ArrayList<>();

	@Inject
	private UserGroupUADTestHelper _userGroupUADTestHelper;

}