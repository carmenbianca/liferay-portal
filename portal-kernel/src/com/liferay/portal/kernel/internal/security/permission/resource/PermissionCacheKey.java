/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.internal.security.permission.resource;

import com.liferay.petra.lang.HashUtil;

import java.util.Objects;

/**
 * @author Preston Crary
 */
public class PermissionCacheKey {

	public PermissionCacheKey(String name, long primaryKey, String actionId) {
		_name = name;
		_primaryKey = primaryKey;
		_actionId = actionId;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PermissionCacheKey)) {
			return false;
		}

		PermissionCacheKey permissionCacheKey = (PermissionCacheKey)object;

		if (Objects.equals(_name, permissionCacheKey._name) &&
			(_primaryKey == permissionCacheKey._primaryKey) &&
			Objects.equals(_actionId, permissionCacheKey._actionId)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hash = HashUtil.hash(0, _name);

		hash = HashUtil.hash(hash, _primaryKey);

		return HashUtil.hash(hash, _actionId);
	}

	private final String _actionId;
	private final String _name;
	private final long _primaryKey;

}