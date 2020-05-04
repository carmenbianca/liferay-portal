/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.staging.processes.web.internal.portlet.action;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManager;
import com.liferay.portal.kernel.exception.NoSuchBackgroundTaskException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.staging.constants.StagingProcessesPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Levente Hudák
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StagingProcessesPortletKeys.STAGING_PROCESSES,
		"mvc.command.name=deleteBackgroundTasks"
	},
	service = MVCActionCommand.class
)
public class DeleteLayoutPublishBackgroundTaskMVCActionCommand
	extends BaseMVCActionCommand {

	protected void deleteBackgroundTask(ActionRequest actionRequest)
		throws PortalException {

		long[] backgroundTaskIds = ParamUtil.getLongValues(
			actionRequest, "deleteBackgroundTaskIds");

		for (long backgroundTaskId : backgroundTaskIds) {
			BackgroundTask backgroundTask =
				_backgroundTaskManager.getBackgroundTask(backgroundTaskId);

			if (!backgroundTask.isInProgress()) {
				_backgroundTaskManager.deleteBackgroundTask(backgroundTaskId);
			}
		}
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			deleteBackgroundTask(actionRequest);
		}
		catch (Exception exception) {
			if (exception instanceof NoSuchBackgroundTaskException ||
				exception instanceof PrincipalException) {

				SessionErrors.add(actionRequest, exception.getClass());

				actionResponse.setRenderParameter(
					"mvcPath", "/error/error.jsp");
			}
			else {
				throw exception;
			}
		}
	}

	@Reference
	private BackgroundTaskManager _backgroundTaskManager;

}