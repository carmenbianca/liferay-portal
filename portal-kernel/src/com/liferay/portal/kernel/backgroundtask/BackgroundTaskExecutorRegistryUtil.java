/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.backgroundtask;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Michael C. Han
 */
public class BackgroundTaskExecutorRegistryUtil {

	public static BackgroundTaskExecutor getBackgroundTaskExecutor(
		String backgroundTaskExecutorClassName) {

		return _backgroundTaskExecutorRegistry.getBackgroundTaskExecutor(
			backgroundTaskExecutorClassName);
	}

	public static void registerBackgroundTaskExecutor(
		String backgroundTaskExecutorClassName,
		BackgroundTaskExecutor backgroundTaskExecutor) {

		_backgroundTaskExecutorRegistry.registerBackgroundTaskExecutor(
			backgroundTaskExecutorClassName, backgroundTaskExecutor);
	}

	public static void unregisterBackgroundTaskExecutor(
		String backgroundTaskExecutorClassName) {

		_backgroundTaskExecutorRegistry.unregisterBackgroundTaskExecutor(
			backgroundTaskExecutorClassName);
	}

	private static volatile BackgroundTaskExecutorRegistry
		_backgroundTaskExecutorRegistry =
			ServiceProxyFactory.newServiceTrackedInstance(
				BackgroundTaskExecutorRegistry.class,
				BackgroundTaskExecutorRegistryUtil.class,
				"_backgroundTaskExecutorRegistry", false);

}