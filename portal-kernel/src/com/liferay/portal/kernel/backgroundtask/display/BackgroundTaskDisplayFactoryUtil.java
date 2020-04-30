/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.backgroundtask.display;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Andrew Betts
 */
public class BackgroundTaskDisplayFactoryUtil {

	public static BackgroundTaskDisplay getBackgroundTaskDisplay(
		BackgroundTask backgroundTask) {

		return _getBackgroundTaskDisplayFactory().getBackgroundTaskDisplay(
			backgroundTask);
	}

	public static BackgroundTaskDisplay getBackgroundTaskDisplay(
		long backgroundTaskId) {

		return _getBackgroundTaskDisplayFactory().getBackgroundTaskDisplay(
			backgroundTaskId);
	}

	private static BackgroundTaskDisplayFactory
		_getBackgroundTaskDisplayFactory() {

		return _backgroundTaskDisplayFactory;
	}

	private static volatile BackgroundTaskDisplayFactory
		_backgroundTaskDisplayFactory =
			ServiceProxyFactory.newServiceTrackedInstance(
				BackgroundTaskDisplayFactory.class,
				BackgroundTaskDisplayFactoryUtil.class,
				"_backgroundTaskDisplayFactory", false);

}