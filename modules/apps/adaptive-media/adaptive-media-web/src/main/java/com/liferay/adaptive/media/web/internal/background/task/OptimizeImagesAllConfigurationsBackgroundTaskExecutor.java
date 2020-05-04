/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.web.internal.background.task;

import com.liferay.adaptive.media.constants.AMOptimizeImagesBackgroundTaskConstants;
import com.liferay.adaptive.media.web.internal.optimizer.AMImageOptimizerUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;

/**
 * @author Sergio González
 */
public class OptimizeImagesAllConfigurationsBackgroundTaskExecutor
	extends OptimizeImagesBackgroundTaskExecutor {

	@Override
	public BackgroundTaskExecutor clone() {
		return new OptimizeImagesAllConfigurationsBackgroundTaskExecutor();
	}

	@Override
	protected void optimizeImages(String configurationEntryUuid, long companyId)
		throws Exception {

		OptimizeImagesStatusMessageSenderUtil.sendStatusMessage(
			AMOptimizeImagesBackgroundTaskConstants.PORTAL_START, companyId,
			configurationEntryUuid);

		AMImageOptimizerUtil.optimize(companyId);

		OptimizeImagesStatusMessageSenderUtil.sendStatusMessage(
			AMOptimizeImagesBackgroundTaskConstants.PORTAL_END, companyId,
			configurationEntryUuid);
	}

}