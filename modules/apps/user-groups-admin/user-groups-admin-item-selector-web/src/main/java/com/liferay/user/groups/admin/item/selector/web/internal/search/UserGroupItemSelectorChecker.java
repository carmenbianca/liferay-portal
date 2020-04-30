/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.groups.admin.item.selector.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.util.ArrayUtil;

import javax.portlet.RenderResponse;

/**
 * @author Alessio Antonio Rendina
 */
public class UserGroupItemSelectorChecker extends EmptyOnClickRowChecker {

	public UserGroupItemSelectorChecker(
		RenderResponse renderResponse, long[] checkedUserGroupIds) {

		super(renderResponse);

		_checkedUserGroupIds = checkedUserGroupIds;
	}

	@Override
	public boolean isChecked(Object obj) {
		UserGroup userGroup = (UserGroup)obj;

		return ArrayUtil.contains(
			_checkedUserGroupIds, userGroup.getUserGroupId());
	}

	@Override
	public boolean isDisabled(Object obj) {
		return isChecked(obj);
	}

	private final long[] _checkedUserGroupIds;

}