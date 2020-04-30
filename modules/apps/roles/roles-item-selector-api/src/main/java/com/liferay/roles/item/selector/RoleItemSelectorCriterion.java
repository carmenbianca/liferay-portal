/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.item.selector;

import com.liferay.item.selector.BaseItemSelectorCriterion;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.util.ArrayUtil;

/**
 * @author Alessio Antonio Rendina
 */
public class RoleItemSelectorCriterion extends BaseItemSelectorCriterion {

	public RoleItemSelectorCriterion() {
	}

	public RoleItemSelectorCriterion(int type) {
		_validateType(type);

		_type = type;
	}

	public long[] getCheckedRoleIds() {
		return _checkedRoleIds;
	}

	public String[] getExcludedRoleNames() {
		return _excludedRoleNames;
	}

	public int getType() {
		return _type;
	}

	public void setCheckedRoleIds(long[] checkedRoleIds) {
		_checkedRoleIds = checkedRoleIds;
	}

	public void setExcludedRoleNames(String[] excludedRoleNames) {
		_excludedRoleNames = excludedRoleNames;
	}

	public void setType(int type) {
		_validateType(type);

		_type = type;
	}

	private void _validateType(int type) {
		if (!ArrayUtil.contains(
				RoleConstants.TYPES_ORGANIZATION_AND_REGULAR_AND_SITE, type)) {

			throw new IllegalArgumentException(
				"Role type must have a value of 1, 2, or 3");
		}
	}

	private long[] _checkedRoleIds = new long[0];
	private String[] _excludedRoleNames = new String[0];
	private int _type = RoleConstants.TYPE_REGULAR;

}