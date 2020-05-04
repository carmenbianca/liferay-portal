/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.index.instant;

import com.liferay.portal.search.spi.index.IndexDefinition;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 */
@Component(
	immediate = true,
	property = {
		IndexDefinition.PROPERTY_KEY_INDEX_NAME + "=" + TasksIndexDefinition.INDEX_NAME_WORKFLOW_TASKS,
		IndexDefinition.PROPERTY_KEY_INDEX_SETTINGS_RESOURCE_NAME + "=" + TasksIndexDefinition.TYPE_MAPPING_FILE_NAME_WORKFLOW_TASKS
	},
	service = IndexDefinition.class
)
public class TasksIndexDefinition implements IndexDefinition {

	public static final String INDEX_NAME_WORKFLOW_TASKS = "workflow-tasks";

	public static final String TYPE_MAPPING_FILE_NAME_WORKFLOW_TASKS =
		"workflow-tasks-type-mappings.json";

}