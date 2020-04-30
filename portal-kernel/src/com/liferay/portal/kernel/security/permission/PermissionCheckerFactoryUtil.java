/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission;

import com.liferay.portal.kernel.model.User;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceTracker;

/**
 * @author Charles May
 * @author Brian Wing Shun Chan
 */
public class PermissionCheckerFactoryUtil {

	public static PermissionChecker create(User user) {
		return getPermissionCheckerFactory().create(user);
	}

	public static PermissionCheckerFactory getPermissionCheckerFactory() {
		return _permissionCheckerFactoryUtil._serviceTracker.getService();
	}

	private PermissionCheckerFactoryUtil() {
		Registry registry = RegistryUtil.getRegistry();

		_serviceTracker = registry.trackServices(
			PermissionCheckerFactory.class);

		_serviceTracker.open();
	}

	private static final PermissionCheckerFactoryUtil
		_permissionCheckerFactoryUtil = new PermissionCheckerFactoryUtil();

	private final ServiceTracker<?, PermissionCheckerFactory> _serviceTracker;

}