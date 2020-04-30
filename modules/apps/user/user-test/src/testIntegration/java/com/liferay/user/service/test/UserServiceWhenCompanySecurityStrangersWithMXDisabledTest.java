/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;
import com.liferay.portal.util.PropsUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Brian Wing Shun Chan
 * @author José Manuel Navarro
 * @author Drew Brokke
 */
@RunWith(Arquillian.class)
public class UserServiceWhenCompanySecurityStrangersWithMXDisabledTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@BeforeClass
	public static void setUpClass() {
		_companySecurityStrangersWithMX = PropsUtil.get(
			PropsKeys.COMPANY_SECURITY_STRANGERS_WITH_MX);

		PropsUtil.set(
			PropsKeys.COMPANY_SECURITY_STRANGERS_WITH_MX,
			Boolean.FALSE.toString());
	}

	@AfterClass
	public static void tearDownClass() {
		PropsUtil.set(
			PropsKeys.COMPANY_SECURITY_STRANGERS_WITH_MX,
			_companySecurityStrangersWithMX);
	}

	@Test(expected = UserEmailAddressException.MustNotUseCompanyMx.class)
	public void testShouldNotAddUser() throws Exception {
		String name = PrincipalThreadLocal.getName();

		try {
			PrincipalThreadLocal.setName(0);

			_user = UserTestUtil.addUser(true);
		}
		finally {
			PrincipalThreadLocal.setName(name);
		}
	}

	@Test(expected = UserEmailAddressException.MustNotUseCompanyMx.class)
	public void testShouldNotUpdateEmailAddress() throws Exception {
		String name = PrincipalThreadLocal.getName();

		try {
			_user = UserTestUtil.addUser(false);

			PrincipalThreadLocal.setName(_user.getUserId());

			String emailAddress =
				"UserServiceTest." + RandomTestUtil.nextLong() + "@liferay.com";

			_userService.updateEmailAddress(
				_user.getUserId(), _user.getPassword(), emailAddress,
				emailAddress, new ServiceContext());
		}
		finally {
			PrincipalThreadLocal.setName(name);
		}
	}

	@Test(expected = UserEmailAddressException.MustNotUseCompanyMx.class)
	public void testShouldNotUpdateUser() throws Exception {
		String name = PrincipalThreadLocal.getName();

		_user = UserTestUtil.addUser(false);

		try {
			PrincipalThreadLocal.setName(_user.getUserId());

			UserTestUtil.updateUser(_user);
		}
		finally {
			PrincipalThreadLocal.setName(name);
		}
	}

	private static String _companySecurityStrangersWithMX;

	@DeleteAfterTestRun
	private User _user;

	@Inject
	private UserLocalService _userLocalService;

	@Inject
	private UserService _userService;

}