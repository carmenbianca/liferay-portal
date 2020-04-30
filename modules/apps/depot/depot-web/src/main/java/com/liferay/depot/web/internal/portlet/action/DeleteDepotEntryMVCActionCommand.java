/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.portlet.action;

import com.liferay.depot.service.DepotEntryService;
import com.liferay.depot.web.internal.constants.DepotPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = {
		"javax.portlet.name=" + DepotPortletKeys.DEPOT_ADMIN,
		"mvc.command.name=/depot/delete_depot_entry"
	},
	service = MVCActionCommand.class
)
public class DeleteDepotEntryMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long depotEntryId = ParamUtil.getLong(actionRequest, "depotEntryId");

		if (depotEntryId > 0) {
			_depotEntryService.deleteDepotEntry(depotEntryId);
		}
		else {
			long[] deleteDepotEntryIds = ParamUtil.getLongValues(
				actionRequest, "rowIds");

			for (long deleteDepotEntryId : deleteDepotEntryIds) {
				_depotEntryService.deleteDepotEntry(deleteDepotEntryId);
			}
		}
	}

	@Reference
	private DepotEntryService _depotEntryService;

}