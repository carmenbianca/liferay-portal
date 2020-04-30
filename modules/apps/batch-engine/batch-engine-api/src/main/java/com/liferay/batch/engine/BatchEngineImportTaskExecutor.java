/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine;

import com.liferay.batch.engine.model.BatchEngineImportTask;

/**
 * @author Shuyang Zhou
 */
public interface BatchEngineImportTaskExecutor {

	public void execute(BatchEngineImportTask batchEngineImportTask);

}