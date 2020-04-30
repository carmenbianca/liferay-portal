/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Ivica Cardic
 */
@ExtendedObjectClassDefinition(category = "batch-engine")
@Meta.OCD(
	id = "com.liferay.batch.engine.configuration.BatchEngineTaskConfiguration",
	localization = "content/Language",
	name = "batch-engine-task-configuration-name"
)
public interface BatchEngineTaskConfiguration {

	@Meta.AD(
		deflt = "14", name = "completed-tasks-cleaner-scan-interval",
		required = false
	)
	public int completedTasksCleanerScanInterval();

	@Meta.AD(name = "csv-file-column-delimiter", required = false)
	public String csvFileColumnDelimiter();

	@Meta.AD(deflt = "100", name = "export-batch-size", required = false)
	public int exportBatchSize();

	@Meta.AD(deflt = "100", name = "import-batch-size", required = false)
	public int importBatchSize();

	@Meta.AD(deflt = "30", name = "orphanage-threshold", required = false)
	public int orphanageThreshold();

	@Meta.AD(deflt = "60", name = "orphan-scan-interval", required = false)
	public int orphanScanInterval();

}