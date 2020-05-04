/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.background.task;

/**
 * @author Michael C. Han
 */
public class BackgroundTaskExecutorNames {

	public static final String DDM_STRUCTURE_INDEXER_BACKGROUND_TASK_EXECUTOR =
		"com.liferay.dynamic.data.mapping.internal.background.task." +
			"DDMStructureIndexerBackgroundTaskExecutor";

	public static final String LAYOUT_EXPORT_BACKGROUND_TASK_EXECUTOR =
		"com.liferay.exportimport.internal.background.task." +
			"LayoutExportBackgroundTaskExecutor";

	public static final String LAYOUT_IMPORT_BACKGROUND_TASK_EXECUTOR =
		"com.liferay.exportimport.internal.background.task." +
			"LayoutImportBackgroundTaskExecutor";

	public static final String LAYOUT_REMOTE_STAGING_BACKGROUND_TASK_EXECUTOR =
		"com.liferay.exportimport.internal.background.task." +
			"LayoutRemoteStagingBackgroundTaskExecutor";

	public static final String LAYOUT_STAGING_BACKGROUND_TASK_EXECUTOR =
		"com.liferay.exportimport.internal.background.task." +
			"LayoutStagingBackgroundTaskExecutor";

	public static final String PORTLET_EXPORT_BACKGROUND_TASK_EXECUTOR =
		"com.liferay.exportimport.internal.background.task." +
			"PortletExportBackgroundTaskExecutor";

	public static final String PORTLET_IMPORT_BACKGROUND_TASK_EXECUTOR =
		"com.liferay.exportimport.internal.background.task." +
			"PortletImportBackgroundTaskExecutor";

	public static final String PORTLET_REMOTE_STAGING_BACKGROUND_TASK_EXECUTOR =
		"com.liferay.exportimport.internal.background.task." +
			"PortletRemoteStagingBackgroundTaskExecutor";

	public static final String PORTLET_STAGING_BACKGROUND_TASK_EXECUTOR =
		"com.liferay.exportimport.internal.background.task." +
			"PortletStagingBackgroundTaskExecutor";

}