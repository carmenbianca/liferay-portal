/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.GroupService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.OrganizationTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.test.util.UserGroupTestUtil;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.security.audit.storage.service.AuditEventService;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Drew Brokke
 */
@RunWith(Arquillian.class)
public class RoleLocalServiceSystemRolesTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Test
	public void testAnalyticsAdminRolePermissions() throws Exception {
		_organization = OrganizationTestUtil.addOrganization();
		_user = UserTestUtil.addUser();
		_userGroup = UserGroupTestUtil.addUserGroup();

		Role role = _roleLocalService.fetchRole(
			TestPropsValues.getCompanyId(),
			RoleConstants.ANALYTICS_ADMINISTRATOR);

		_roleLocalService.addUserRole(_user.getUserId(), role.getRoleId());

		PermissionChecker oldPermissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		PermissionThreadLocal.setPermissionChecker(
			PermissionCheckerFactoryUtil.create(_user));

		try {
			_groupService.getGtGroups(
				0, TestPropsValues.getCompanyId(), 0, true, 5);

			_userService.getCompanyUsers(
				TestPropsValues.getCompanyId(), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
			_userService.getCompanyUsersCount(TestPropsValues.getCompanyId());
			_userService.getGtCompanyUsers(
				0, TestPropsValues.getCompanyId(), 5);
			_userService.getGtOrganizationUsers(
				0, _organization.getOrganizationId(), 5);
			_userService.getGtUserGroupUsers(0, _userGroup.getUserGroupId(), 5);
			_userService.getOrganizationsAndUserGroupsUsersCount(
				new long[] {_organization.getOrganizationId()},
				new long[] {_userGroup.getUserGroupId()});

			_auditEventService.getAuditEvents(
				TestPropsValues.getCompanyId(), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
			_auditEventService.getAuditEvents(
				TestPropsValues.getCompanyId(), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);
			_auditEventService.getAuditEvents(
				TestPropsValues.getCompanyId(), _user.getUserId(),
				_user.getScreenName(), null, null, null, null, null, null, null,
				null, 0, null, true, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			_auditEventService.getAuditEvents(
				TestPropsValues.getCompanyId(), _user.getUserId(),
				_user.getScreenName(), null, null, null, null, null, null, null,
				null, 0, null, true, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);
		}
		finally {
			PermissionThreadLocal.setPermissionChecker(oldPermissionChecker);
		}
	}

	@Inject
	private AuditEventService _auditEventService;

	@Inject
	private GroupService _groupService;

	@DeleteAfterTestRun
	private Organization _organization;

	@Inject
	private RoleLocalService _roleLocalService;

	@DeleteAfterTestRun
	private User _user;

	@DeleteAfterTestRun
	private UserGroup _userGroup;

	@Inject
	private UserService _userService;

}