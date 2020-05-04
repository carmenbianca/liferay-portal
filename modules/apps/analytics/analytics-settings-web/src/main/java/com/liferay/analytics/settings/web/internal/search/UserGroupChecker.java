/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.settings.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.UserGroup;

import java.util.Set;

import javax.portlet.RenderResponse;

/**
 * @author Geyson Silva
 */
public class UserGroupChecker extends EmptyOnClickRowChecker {

	public UserGroupChecker(RenderResponse renderResponse, Set<String> ids) {
		super(renderResponse);

		setRowIds("syncedUserGroupIds");

		_ids = ids;
	}

	@Override
	public boolean isChecked(Object obj) {
		UserGroup userGroup = (UserGroup)obj;

		return _ids.contains(String.valueOf(userGroup.getUserGroupId()));
	}

	private final Set<String> _ids;

}