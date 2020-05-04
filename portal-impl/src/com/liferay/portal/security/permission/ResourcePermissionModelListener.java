/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.permission;

import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.model.impl.ResourcePermissionModelImpl;

/**
 * @author Preston Crary
 */
public class ResourcePermissionModelListener
	extends BaseModelListener<ResourcePermission> {

	@Override
	public void onAfterCreate(ResourcePermission resourcePermission) {
		_clearCache(resourcePermission);
	}

	@Override
	public void onAfterRemove(ResourcePermission resourcePermission) {
		_clearCache(resourcePermission);
	}

	@Override
	public void onAfterUpdate(ResourcePermission resourcePermission) {
		_clearCache(resourcePermission);
	}

	@Override
	public void onBeforeUpdate(ResourcePermission resourcePermission) {
		ResourcePermissionModelImpl resourcePermissionModelImpl =
			(ResourcePermissionModelImpl)resourcePermission;

		long columnBitmask = resourcePermissionModelImpl.getColumnBitmask();

		if ((columnBitmask & _CLEAR_ON_BEFORE_BITMASK) != 0) {
			PermissionCacheUtil.clearResourcePermissionCache(
				resourcePermissionModelImpl.getOriginalScope(),
				resourcePermissionModelImpl.getOriginalName(),
				resourcePermissionModelImpl.getOriginalPrimKey());
		}
	}

	private void _clearCache(ResourcePermission resourcePermission) {
		if (resourcePermission != null) {
			PermissionCacheUtil.clearResourcePermissionCache(
				resourcePermission.getScope(), resourcePermission.getName(),
				resourcePermission.getPrimKey());
		}
	}

	private static final long _CLEAR_ON_BEFORE_BITMASK =
		ResourcePermissionModelImpl.NAME_COLUMN_BITMASK |
		ResourcePermissionModelImpl.PRIMKEY_COLUMN_BITMASK;

}