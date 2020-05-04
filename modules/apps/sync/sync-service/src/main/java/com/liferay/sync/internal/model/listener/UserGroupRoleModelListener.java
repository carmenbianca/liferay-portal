/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.UserGroupRole;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sherly Liu
 */
@Component(immediate = true, service = ModelListener.class)
public class UserGroupRoleModelListener
	extends SyncBaseModelListener<UserGroupRole> {

	@Override
	public void onAfterCreate(UserGroupRole userGroupRole)
		throws ModelListenerException {

		onAddRoleAssociation(userGroupRole.getRoleId());
	}

	@Override
	public void onAfterRemove(UserGroupRole userGroupRole)
		throws ModelListenerException {

		onRemoveRoleAssociation(userGroupRole.getRoleId());
	}

}