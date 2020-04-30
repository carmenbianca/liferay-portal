/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.backgroundtask;

/**
 * @author Michael C. Han
 */
public interface BackgroundTaskExecutorRegistry {

	public BackgroundTaskExecutor getBackgroundTaskExecutor(
		String backgroundTaskExecutorClassName);

	public void registerBackgroundTaskExecutor(
		String backgroundTaskExecutorClassName,
		BackgroundTaskExecutor backgroundTaskExecutor);

	public void unregisterBackgroundTaskExecutor(
		String backgroundTaskExecutorClassName);

}