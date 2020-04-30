/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;

/**
 * @author Adolfo Pérez
 */
public abstract class BaseBlogsPortlet extends MVCPortlet {

	@Override
	protected boolean isAddSuccessMessage(ActionRequest actionRequest) {
		boolean ajax = ParamUtil.getBoolean(actionRequest, "ajax");

		if (ajax) {
			return false;
		}

		return super.isAddSuccessMessage(actionRequest);
	}

}