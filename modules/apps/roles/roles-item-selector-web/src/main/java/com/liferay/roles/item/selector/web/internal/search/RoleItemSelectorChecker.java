/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.item.selector.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.util.ArrayUtil;

import javax.portlet.RenderResponse;

/**
 * @author Alessio Antonio Rendina
 */
public class RoleItemSelectorChecker extends EmptyOnClickRowChecker {

	public RoleItemSelectorChecker(
		RenderResponse renderResponse, long[] checkedRoleIds,
		String[] excludedRoleNames) {

		super(renderResponse);

		_checkedRoleIds = checkedRoleIds;
		_excludedRoleNames = excludedRoleNames;
	}

	@Override
	public boolean isChecked(Object obj) {
		Role role = (Role)obj;

		return ArrayUtil.contains(_checkedRoleIds, role.getRoleId());
	}

	@Override
	public boolean isDisabled(Object obj) {
		Role role = (Role)obj;

		return ArrayUtil.contains(_excludedRoleNames, role.getName());
	}

	private final long[] _checkedRoleIds;
	private final String[] _excludedRoleNames;

}