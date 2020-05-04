/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.permission;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactory;
import com.liferay.portal.kernel.security.permission.contributor.RoleContributor;
import com.liferay.portal.kernel.security.permission.wrapper.PermissionCheckerWrapperFactory;
import com.liferay.portal.util.PropsValues;
import com.liferay.registry.collections.ServiceTrackerCollections;
import com.liferay.registry.collections.ServiceTrackerList;

/**
 * @author Charles May
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class PermissionCheckerFactoryImpl implements PermissionCheckerFactory {

	public PermissionCheckerFactoryImpl() throws Exception {
		Class<PermissionChecker> clazz =
			(Class<PermissionChecker>)Class.forName(
				PropsValues.PERMISSIONS_CHECKER);

		_permissionChecker = clazz.newInstance();
	}

	public void afterPropertiesSet() {
		_permissionCheckerWrapperFactories = ServiceTrackerCollections.openList(
			PermissionCheckerWrapperFactory.class);
		_roleContributors = ServiceTrackerCollections.openList(
			RoleContributor.class);
	}

	@Override
	public PermissionChecker create(User user) {
		PermissionChecker permissionChecker = _permissionChecker.clone();

		permissionChecker.init(
			user, _roleContributors.toArray(new RoleContributor[0]));

		permissionChecker = new StagingPermissionChecker(permissionChecker);

		for (PermissionCheckerWrapperFactory permissionCheckerWrapperFactory :
				_permissionCheckerWrapperFactories) {

			permissionChecker =
				permissionCheckerWrapperFactory.wrapPermissionChecker(
					permissionChecker);
		}

		return permissionChecker;
	}

	public void destroy() {
		_permissionCheckerWrapperFactories.close();
		_roleContributors.close();
	}

	private final PermissionChecker _permissionChecker;
	private ServiceTrackerList<PermissionCheckerWrapperFactory>
		_permissionCheckerWrapperFactories;
	private ServiceTrackerList<RoleContributor> _roleContributors;

}