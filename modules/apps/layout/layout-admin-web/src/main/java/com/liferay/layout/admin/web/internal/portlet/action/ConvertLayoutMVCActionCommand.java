/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.portlet.action;

import com.liferay.layout.admin.constants.LayoutAdminPortletKeys;
import com.liferay.layout.util.BulkLayoutConverter;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + LayoutAdminPortletKeys.GROUP_PAGES,
		"mvc.command.name=/layout/convert_layout"
	},
	service = MVCActionCommand.class
)
public class ConvertLayoutMVCActionCommand
	extends BaseMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		return super.processAction(actionRequest, actionResponse);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] selPlids = null;

		long selPlid = ParamUtil.getLong(actionRequest, "selPlid");

		if (selPlid > 0) {
			selPlids = new long[] {selPlid};
		}
		else {
			selPlids = ParamUtil.getLongValues(actionRequest, "rowIds");
		}

		for (long curSelPlid : selPlids) {
			_bulkLayoutConverter.convertLayout(curSelPlid);
		}
	}

	@Reference
	private BulkLayoutConverter _bulkLayoutConverter;

}