/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.membershippolicy;

import com.liferay.portal.kernel.model.Role;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 * @author Roberto Díaz
 * @author Sergio González
 */
public class DummyRoleMembershipPolicy extends BaseRoleMembershipPolicy {

	@Override
	public void checkRoles(
		long[] userIds, long[] addRoleIds, long[] removeRoleIds) {
	}

	@Override
	public boolean isRoleAllowed(long userId, long roleId) {
		return true;
	}

	@Override
	public boolean isRoleRequired(long userId, long roleId) {
		return false;
	}

	@Override
	public void propagateRoles(
		long[] userIds, long[] addRoleIds, long[] removeRoleIds) {
	}

	@Override
	public void verifyPolicy(Role role) {
	}

	@Override
	public void verifyPolicy(
		Role role, Role oldRole,
		Map<String, Serializable> oldExpandoAttributes) {
	}

}