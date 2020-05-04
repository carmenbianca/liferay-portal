/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.action;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.UserReminderQueryException;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.Action;
import com.liferay.portal.struts.ActionConstants;
import com.liferay.portal.struts.model.ActionForward;
import com.liferay.portal.struts.model.ActionMapping;
import com.liferay.users.admin.kernel.util.UsersAdmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class UpdateReminderQueryAction implements Action {

	@Override
	public ActionForward execute(
			ActionMapping actionMapping, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		String cmd = ParamUtil.getString(httpServletRequest, Constants.CMD);

		if (Validator.isNull(cmd)) {
			return actionMapping.getActionForward(
				"portal.update_reminder_query");
		}

		try {
			updateReminderQuery(httpServletRequest, httpServletResponse);

			return actionMapping.getActionForward(
				ActionConstants.COMMON_REFERER_JSP);
		}
		catch (Exception exception) {
			if (exception instanceof UserReminderQueryException) {
				SessionErrors.add(httpServletRequest, exception.getClass());

				return actionMapping.getActionForward(
					"portal.update_reminder_query");
			}
			else if (exception instanceof NoSuchUserException ||
					 exception instanceof PrincipalException) {

				SessionErrors.add(httpServletRequest, exception.getClass());

				return actionMapping.getActionForward("portal.error");
			}

			PortalUtil.sendError(
				exception, httpServletRequest, httpServletResponse);

			return null;
		}
	}

	protected void updateReminderQuery(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		AuthTokenUtil.checkCSRFToken(
			httpServletRequest, UpdateReminderQueryAction.class.getName());

		long userId = PortalUtil.getUserId(httpServletRequest);
		String question = ParamUtil.getString(
			httpServletRequest, "reminderQueryQuestion");
		String answer = ParamUtil.getString(
			httpServletRequest, "reminderQueryAnswer");

		if (question.equals(UsersAdmin.CUSTOM_QUESTION)) {
			question = ParamUtil.getString(
				httpServletRequest, "reminderQueryCustomQuestion");
		}

		UserServiceUtil.updateReminderQuery(userId, question, answer);
	}

}