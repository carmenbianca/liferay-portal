/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.liferay.tasks.asset.model;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.tasks.model.TasksEntry;
import com.liferay.tasks.service.TasksEntryLocalServiceUtil;
import com.liferay.tasks.service.permission.TasksEntryPermission;

/**
 * @author Matthew Kong
 */
public class TasksEntryAssetRendererFactory
	extends BaseAssetRendererFactory<TasksEntry> {

	public static final String CLASS_NAME = TasksEntry.class.getName();

	public static final String TYPE = "tasks";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException {

		return new TasksEntryAssetRenderer(
			TasksEntryLocalServiceUtil.getTasksEntry(classPK));
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getIconCssClass() {
		return "icon-tasks";
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return TasksEntryPermission.contains(
			permissionChecker, classPK, actionId);
	}

}