/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dependency.manager;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Shuyang Zhou
 */
public class DependencyManagerSyncUtil {

	public static void sync() {
		_dependencyManagerSync.sync();
	}

	private static volatile DependencyManagerSync _dependencyManagerSync =
		ServiceProxyFactory.newServiceTrackedInstance(
			DependencyManagerSync.class, DependencyManagerSyncUtil.class,
			"_dependencyManagerSync", false);

}