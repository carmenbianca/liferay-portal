/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.internal.model.listener.test;

import com.liferay.account.model.AccountEntry;
import com.liferay.account.model.AccountRole;
import com.liferay.account.service.AccountEntryLocalService;
import com.liferay.account.service.AccountRoleLocalService;
import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.CompanyTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Drew Brokke
 */
@RunWith(Arquillian.class)
public class CompanyModelListenerTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_company = CompanyTestUtil.addCompany();

		_defaultUser = _company.getDefaultUser();

		_accountEntry = _accountEntryLocalService.addAccountEntry(
			_defaultUser.getUserId(), 0L, RandomTestUtil.randomString(50),
			RandomTestUtil.randomString(50), null, null,
			WorkflowConstants.STATUS_APPROVED);
	}

	@Test
	public void testCleanUpAccountEntries() throws Exception {
		_deleteCompany();

		Assert.assertNull(
			_accountEntryLocalService.fetchAccountEntry(
				_accountEntry.getAccountEntryId()));
	}

	@Test
	public void testCleanUpAccountRoles() throws Exception {
		AccountRole accountRole = _accountRoleLocalService.addAccountRole(
			_defaultUser.getUserId(), _accountEntry.getAccountEntryId(),
			RandomTestUtil.randomString(), null, null);

		_deleteCompany();

		Assert.assertNull(
			_accountRoleLocalService.fetchAccountRole(
				accountRole.getAccountRoleId()));
	}

	private void _deleteCompany() throws Exception {
		_companyLocalService.deleteCompany(_company);

		_company = null;
	}

	private AccountEntry _accountEntry;

	@Inject
	private AccountEntryLocalService _accountEntryLocalService;

	@Inject
	private AccountRoleLocalService _accountRoleLocalService;

	@DeleteAfterTestRun
	private Company _company;

	@Inject
	private CompanyLocalService _companyLocalService;

	private User _defaultUser;

}