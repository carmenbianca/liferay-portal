/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.admin.web.internal.portlet.action;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ResourceRequest;

/**
 * @author Jürgen Kappler
 */
public class ActionUtil {

	public static List<Group> getGroups(ResourceRequest request)
		throws Exception {

		long[] groupIds = ParamUtil.getLongValues(request, "rowIds");

		List<Group> groups = new ArrayList<>();

		for (long groupId : groupIds) {
			groups.add(GroupServiceUtil.getGroup(groupId));
		}

		return groups;
	}

}