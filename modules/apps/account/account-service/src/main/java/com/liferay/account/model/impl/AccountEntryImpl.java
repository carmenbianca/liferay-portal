/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.model.impl;

import com.liferay.account.model.AccountEntry;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class AccountEntryImpl extends AccountEntryBaseImpl {

	public AccountEntryImpl() {
	}

	public Group getAccountEntryGroup() {
		return _getAccountEntryGroup();
	}

	public long getAccountEntryGroupId() {
		Group group = _getAccountEntryGroup();

		if (group == null) {
			return GroupConstants.DEFAULT_LIVE_GROUP_ID;
		}

		return group.getGroupId();
	}

	private Group _getAccountEntryGroup() {
		return GroupLocalServiceUtil.fetchGroup(
			getCompanyId(),
			ClassNameLocalServiceUtil.getClassNameId(AccountEntry.class),
			getAccountEntryId());
	}

}