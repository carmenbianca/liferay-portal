/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.internal.role;

import com.liferay.account.role.AccountRole;
import com.liferay.portal.kernel.model.Role;

/**
 * @author Drew Brokke
 */
public class AccountRoleImpl implements AccountRole {

	public AccountRoleImpl(Role role) {
		_role = role;
	}

	@Override
	public String getName() {
		return _role.getName();
	}

	@Override
	public long getRoleId() {
		return _role.getRoleId();
	}

	private final Role _role;

}