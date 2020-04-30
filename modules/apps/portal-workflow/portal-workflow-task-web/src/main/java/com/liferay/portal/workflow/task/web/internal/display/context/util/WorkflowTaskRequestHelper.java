/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.task.web.internal.display.context.util;

import com.liferay.portal.kernel.display.context.util.BaseRequestHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Leonardo Barros
 */
public class WorkflowTaskRequestHelper extends BaseRequestHelper {

	public WorkflowTaskRequestHelper(HttpServletRequest httpServletRequest) {
		super(httpServletRequest);
	}

}