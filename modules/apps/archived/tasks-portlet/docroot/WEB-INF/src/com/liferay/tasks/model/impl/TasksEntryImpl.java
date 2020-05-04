/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.liferay.tasks.model.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.tasks.model.TasksEntryConstants;

/**
 * @author Ryan Park
 */
public class TasksEntryImpl extends TasksEntryBaseImpl {

	public TasksEntryImpl() {
	}

	@Override
	public String getAssigneeFullName() {
		return getUserFullName(getAssigneeUserId());
	}

	@Override
	public String getPriorityLabel() {
		return TasksEntryConstants.getPriorityLabel(getPriority());
	}

	@Override
	public String getReporterFullName() {
		return getUserFullName(getUserId());
	}

	@Override
	public String getStatusLabel() {
		return TasksEntryConstants.getStatusLabel(getStatus());
	}

	protected String getUserFullName(long userId) {
		String fullName = StringPool.BLANK;

		try {
			User user = UserLocalServiceUtil.getUser(userId);

			fullName = user.getFullName();
		}
		catch (Exception exception) {
		}

		return fullName;
	}

}