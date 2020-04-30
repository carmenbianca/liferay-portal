/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.backgroundtask;

/**
 * @author Michael C. Han
 */
public interface BackgroundTaskStatusRegistry {

	public BackgroundTaskStatus getBackgroundTaskStatus(long backgroundTaskId);

	public BackgroundTaskStatus registerBackgroundTaskStatus(
		long backgroundTaskId);

	public BackgroundTaskStatus unregisterBackgroundTaskStatus(
		long backgroundTaskId);

}