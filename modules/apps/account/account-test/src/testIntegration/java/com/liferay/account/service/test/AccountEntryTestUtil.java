/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.service.test;

import com.liferay.account.model.AccountEntry;
import com.liferay.account.service.AccountEntryLocalService;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * @author Drew Brokke
 */
public class AccountEntryTestUtil {

	public static AccountEntry addAccountEntry(
			AccountEntryLocalService accountEntryLocalService)
		throws Exception {

		return addAccountEntry(
			accountEntryLocalService, WorkflowConstants.STATUS_APPROVED);
	}

	public static AccountEntry addAccountEntry(
			AccountEntryLocalService accountEntryLocalService, int status)
		throws Exception {

		return accountEntryLocalService.addAccountEntry(
			TestPropsValues.getUserId(), 0L, RandomTestUtil.randomString(50),
			RandomTestUtil.randomString(50), null, null, status);
	}

	public static AccountEntry addAccountEntry(
			AccountEntryLocalService accountEntryLocalService, String name,
			String description)
		throws Exception {

		return accountEntryLocalService.addAccountEntry(
			TestPropsValues.getUserId(), 0L, name, description, null, null,
			WorkflowConstants.STATUS_APPROVED);
	}

	public static AccountEntry addAccountEntry(
			AccountEntryLocalService accountEntryLocalService, String[] domains)
		throws Exception {

		return accountEntryLocalService.addAccountEntry(
			TestPropsValues.getUserId(), 0L, RandomTestUtil.randomString(50),
			RandomTestUtil.randomString(50), domains, null,
			WorkflowConstants.STATUS_APPROVED);
	}

}