/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.background.task.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for BackgroundTask. This utility wraps
 * <code>com.liferay.portal.background.task.service.impl.BackgroundTaskServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BackgroundTaskService
 * @generated
 */
public class BackgroundTaskServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.background.task.service.impl.BackgroundTaskServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static int getBackgroundTasksCount(
		long groupId, String taskExecutorClassName, boolean completed) {

		return getService().getBackgroundTasksCount(
			groupId, taskExecutorClassName, completed);
	}

	public static int getBackgroundTasksCount(
		long groupId, String name, String taskExecutorClassName) {

		return getService().getBackgroundTasksCount(
			groupId, name, taskExecutorClassName);
	}

	public static String getBackgroundTaskStatusJSON(long backgroundTaskId) {
		return getService().getBackgroundTaskStatusJSON(backgroundTaskId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static BackgroundTaskService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BackgroundTaskService, BackgroundTaskService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BackgroundTaskService.class);

		ServiceTracker<BackgroundTaskService, BackgroundTaskService>
			serviceTracker =
				new ServiceTracker
					<BackgroundTaskService, BackgroundTaskService>(
						bundle.getBundleContext(), BackgroundTaskService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}