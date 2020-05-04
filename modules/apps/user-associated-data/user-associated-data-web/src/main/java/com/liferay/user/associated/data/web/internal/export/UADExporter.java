/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.web.internal.export;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.user.associated.data.web.internal.export.background.task.UADExportBackgroundTaskExecutor;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Pei-Jung Lan
 */
public class UADExporter {

	public static long exportApplicationDataInBackground(
			String applicationKey, long userId, long groupId)
		throws PortalException {

		Map<String, Serializable> taskContextMap =
			HashMapBuilder.<String, Serializable>put(
				"applicationKey", applicationKey
			).build();

		PortletFileRepositoryUtil.addPortletRepository(
			groupId, PortletKeys.BACKGROUND_TASK, new ServiceContext());

		long defaultUserId = UserLocalServiceUtil.getDefaultUserId(
			CompanyThreadLocal.getCompanyId());

		BackgroundTask backgroundTask =
			BackgroundTaskManagerUtil.addBackgroundTask(
				defaultUserId, groupId, String.valueOf(userId),
				UADExportBackgroundTaskExecutor.class.getName(), taskContextMap,
				new ServiceContext());

		return backgroundTask.getBackgroundTaskId();
	}

}