/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.search.background.task.ReindexBackgroundTaskConstants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.search.internal.background.task.display.ReindexBackgroundTaskDisplay;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Andrew Betts
 */
public abstract class ReindexBackgroundTaskExecutor
	extends BaseBackgroundTaskExecutor {

	public ReindexBackgroundTaskExecutor() {
		setBackgroundTaskStatusMessageTranslator(
			new ReindexBackgroundTaskStatusMessageTranslator());
		setIsolationLevel(BackgroundTaskConstants.ISOLATION_LEVEL_COMPANY);
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask)
		throws Exception {

		Map<String, Serializable> taskContextMap =
			backgroundTask.getTaskContextMap();

		String className = (String)taskContextMap.get(
			ReindexBackgroundTaskConstants.CLASS_NAME);
		long[] companyIds = GetterUtil.getLongValues(
			taskContextMap.get(ReindexBackgroundTaskConstants.COMPANY_IDS));

		reindex(className, companyIds);

		return BackgroundTaskResult.SUCCESS;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(
		BackgroundTask backgroundTask) {

		return new ReindexBackgroundTaskDisplay(backgroundTask);
	}

	protected abstract void reindex(String className, long[] companyIds)
		throws Exception;

}