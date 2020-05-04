/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.groups.admin.web.internal.portlet.action;

import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pei-Jung Lan
 */
public class ActionUtil {

	public static UserGroup getUserGroup(HttpServletRequest httpServletRequest)
		throws Exception {

		long userGroupId = ParamUtil.getLong(httpServletRequest, "userGroupId");

		UserGroup userGroup = null;

		if (userGroupId > 0) {
			userGroup = UserGroupServiceUtil.fetchUserGroup(userGroupId);
		}

		return userGroup;
	}

	public static UserGroup getUserGroup(PortletRequest portletRequest)
		throws Exception {

		return getUserGroup(PortalUtil.getHttpServletRequest(portletRequest));
	}

}