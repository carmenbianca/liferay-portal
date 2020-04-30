/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.portlet.action;

import com.liferay.layout.admin.constants.LayoutAdminPortletKeys;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.LayoutService;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + LayoutAdminPortletKeys.GROUP_PAGES,
		"mvc.command.name=/layout/move_layout"
	},
	service = MVCActionCommand.class
)
public class MoveLayoutMVCActionCommand extends BaseAddLayoutMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long plid = ParamUtil.getLong(actionRequest, "plid");

		long parentPlid = ParamUtil.getLong(actionRequest, "parentPlid");
		int priority = ParamUtil.getInteger(
			actionRequest, "priority", Integer.MAX_VALUE);

		Layout layout = layoutLocalService.fetchLayout(plid);

		if (layout.getParentPlid() == parentPlid) {
			_layoutService.updatePriority(plid, priority);
		}
		else {
			_layoutService.updatePriority(plid, Integer.MAX_VALUE);

			_layoutService.updateParentLayoutIdAndPriority(
				plid, parentPlid, priority);
		}
	}

	@Reference
	private LayoutService _layoutService;

}