/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.internal.upgrade.v1_0_1;

import com.liferay.exportimport.internal.upgrade.BaseUpgradeBackgroundTaskExecutorClassNames;
import com.liferay.exportimport.kernel.background.task.BackgroundTaskExecutorNames;

/**
 * @author Jonathan McCann
 */
public class UpgradeBackgroundTaskExecutorClassNames
	extends BaseUpgradeBackgroundTaskExecutorClassNames {

	@Override
	protected String[][] getRenameTaskExecutorClassNames() {
		return new String[][] {
			{
				"com.liferay.dynamic.data.mapping.background.task." +
					"DDMStructureIndexerBackgroundTaskExecutor",
				BackgroundTaskExecutorNames.
					DDM_STRUCTURE_INDEXER_BACKGROUND_TASK_EXECUTOR
			}
		};
	}

}