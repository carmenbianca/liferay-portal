/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission;

/**
 * @author Preston Crary
 */
public class RolePermissions {

	public RolePermissions(
		String name, int scope, String actionId, long roleId) {

		_name = name;
		_scope = scope;
		_actionId = actionId;
		_roleId = roleId;
	}

	public String getActionId() {
		return _actionId;
	}

	public String getName() {
		return _name;
	}

	public long getRoleId() {
		return _roleId;
	}

	public int getScope() {
		return _scope;
	}

	private final String _actionId;
	private final String _name;
	private final long _roleId;
	private final int _scope;

}