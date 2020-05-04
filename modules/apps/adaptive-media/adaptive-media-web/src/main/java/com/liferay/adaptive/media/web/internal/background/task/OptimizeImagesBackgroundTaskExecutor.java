/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.web.internal.background.task;

import com.liferay.adaptive.media.constants.AMOptimizeImagesBackgroundTaskConstants;
import com.liferay.adaptive.media.web.internal.background.task.display.OptimizeImagesBackgroundTaskDisplay;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.util.GetterUtil;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Sergio González
 */
public abstract class OptimizeImagesBackgroundTaskExecutor
	extends BaseBackgroundTaskExecutor {

	public OptimizeImagesBackgroundTaskExecutor() {
		setBackgroundTaskStatusMessageTranslator(
			new OptimizeImagesBackgroundTaskStatusMessageTranslator());
		setIsolationLevel(BackgroundTaskConstants.ISOLATION_LEVEL_COMPANY);
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask)
		throws Exception {

		Map<String, Serializable> taskContextMap =
			backgroundTask.getTaskContextMap();

		String configurationEntryUuid = (String)taskContextMap.get(
			AMOptimizeImagesBackgroundTaskConstants.CONFIGURATION_ENTRY_UUID);
		long companyId = GetterUtil.getLong(
			taskContextMap.get(
				AMOptimizeImagesBackgroundTaskConstants.COMPANY_ID));

		optimizeImages(configurationEntryUuid, companyId);

		return BackgroundTaskResult.SUCCESS;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(
		BackgroundTask backgroundTask) {

		return new OptimizeImagesBackgroundTaskDisplay(backgroundTask);
	}

	protected abstract void optimizeImages(
			String configurationEntryUuid, long companyId)
		throws Exception;

}