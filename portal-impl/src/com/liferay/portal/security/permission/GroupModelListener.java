/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.permission;

import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;

/**
 * @author Preston Crary
 */
public class GroupModelListener extends BaseModelListener<Group> {

	@Override
	public void onAfterAddAssociation(
		Object classPK, String associationClassName,
		Object associationClassPK) {

		if (!associationClassName.equals(User.class.getName())) {
			PermissionCacheUtil.clearCache();
		}
	}

	@Override
	public void onAfterRemove(Group group) {
		PermissionCacheUtil.clearCache();
	}

	@Override
	public void onAfterRemoveAssociation(
		Object classPK, String associationClassName,
		Object associationClassPK) {

		if (!associationClassName.equals(User.class.getName())) {
			PermissionCacheUtil.clearCache();
		}
	}

}