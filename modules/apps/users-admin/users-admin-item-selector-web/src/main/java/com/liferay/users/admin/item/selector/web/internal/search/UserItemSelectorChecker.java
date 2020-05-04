/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.item.selector.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ArrayUtil;

import javax.portlet.RenderResponse;

/**
 * @author Alessio Antonio Rendina
 */
public class UserItemSelectorChecker extends EmptyOnClickRowChecker {

	public UserItemSelectorChecker(
		RenderResponse renderResponse, long[] checkedUserIds) {

		super(renderResponse);

		_checkedUserIds = checkedUserIds;
	}

	@Override
	public boolean isChecked(Object obj) {
		User user = (User)obj;

		return ArrayUtil.contains(_checkedUserIds, user.getUserId());
	}

	@Override
	public boolean isDisabled(Object obj) {
		return isChecked(obj);
	}

	private final long[] _checkedUserIds;

}