/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.permission;

import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.User;

/**
 * @author Preston Crary
 */
public class UserModelListener extends BaseModelListener<User> {

	@Override
	public void onAfterAddAssociation(
		Object classPK, String associationClassName,
		Object associationClassPK) {

		PermissionCacheUtil.clearCache((long)classPK);
	}

	@Override
	public void onAfterRemove(User user) {
		if (user != null) {
			PermissionCacheUtil.clearCache(user.getUserId());
		}
	}

	@Override
	public void onAfterRemoveAssociation(
		Object classPK, String associationClassName,
		Object associationClassPK) {

		PermissionCacheUtil.clearCache((long)classPK);
	}

}