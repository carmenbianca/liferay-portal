/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.web.internal.portlet.action;

import com.liferay.asset.list.constants.AssetListPortletKeys;
import com.liferay.asset.list.service.AssetListEntryService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AssetListPortletKeys.ASSET_LIST,
		"mvc.command.name=/asset_list/delete_asset_list_entry"
	},
	service = MVCActionCommand.class
)
public class DeleteAssetListEntriesMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] deleteAssetListEntryIds = null;

		long assetListEntryId = ParamUtil.getLong(
			actionRequest, "assetListEntryId");

		if (assetListEntryId > 0) {
			deleteAssetListEntryIds = new long[] {assetListEntryId};
		}
		else {
			deleteAssetListEntryIds = ParamUtil.getLongValues(
				actionRequest, "rowIds");
		}

		try {
			_assetListEntryService.deleteAssetListEntries(
				deleteAssetListEntryIds);
		}
		catch (PortalException portalException) {
			SessionErrors.add(actionRequest, portalException.getClass());

			hideDefaultErrorMessage(actionRequest);

			sendRedirect(actionRequest, actionResponse);
		}
	}

	@Reference
	private AssetListEntryService _assetListEntryService;

}