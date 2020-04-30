/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.backgroundtask;

import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;

/**
 * @author Michael C. Han
 */
public interface BackgroundTaskExecutor {

	public BackgroundTaskExecutor clone();

	public BackgroundTaskResult execute(BackgroundTask backgroundTask)
		throws Exception;

	public String generateLockKey(BackgroundTask backgroundTask);

	public BackgroundTaskDisplay getBackgroundTaskDisplay(
		BackgroundTask backgroundTask);

	public BackgroundTaskStatusMessageTranslator
		getBackgroundTaskStatusMessageTranslator();

	public int getIsolationLevel();

	public String handleException(
		BackgroundTask backgroundTask, Exception exception);

	public boolean isSerial();

}