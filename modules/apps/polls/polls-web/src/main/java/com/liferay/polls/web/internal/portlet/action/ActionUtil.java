/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.web.internal.portlet.action;

import com.liferay.polls.constants.PollsWebKeys;
import com.liferay.polls.model.PollsQuestion;
import com.liferay.polls.service.PollsQuestionServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class ActionUtil {

	public static void getQuestion(HttpServletRequest httpServletRequest)
		throws Exception {

		long questionId = ParamUtil.getLong(httpServletRequest, "questionId");

		PollsQuestion question = null;

		if (questionId > 0) {
			question = PollsQuestionServiceUtil.getQuestion(questionId);
		}

		httpServletRequest.setAttribute(PollsWebKeys.POLLS_QUESTION, question);
	}

	public static void getQuestion(PortletRequest portletRequest)
		throws Exception {

		getQuestion(PortalUtil.getHttpServletRequest(portletRequest));
	}

}