/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.web.internal.portlet.action;

import com.liferay.asset.list.constants.AssetListEntryTypeConstants;
import com.liferay.asset.list.constants.AssetListPortletKeys;
import com.liferay.asset.list.service.AssetListEntryService;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AssetListPortletKeys.ASSET_LIST,
		"mvc.command.name=/asset_list/add_asset_list_entry_variation"
	},
	service = MVCActionCommand.class
)
public class AddAssetListEntryVariationMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long assetListEntryId = ParamUtil.getLong(
			actionRequest, "assetListEntryId");

		long segmentsEntryId = ParamUtil.getLong(
			actionRequest, "segmentsEntryId");

		String typeSettings = null;

		int type = ParamUtil.getInteger(actionRequest, "type");

		if (type == AssetListEntryTypeConstants.TYPE_DYNAMIC) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			UnicodeProperties unicodeProperties = new UnicodeProperties(true);

			unicodeProperties.setProperty(
				"groupIds", String.valueOf(themeDisplay.getScopeGroupId()));

			typeSettings = unicodeProperties.toString();
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		_assetListEntryService.updateAssetListEntry(
			assetListEntryId, segmentsEntryId, typeSettings, serviceContext);

		sendRedirect(
			actionRequest, actionResponse,
			getRedirectURL(actionResponse, assetListEntryId, segmentsEntryId));
	}

	protected String getRedirectURL(
		ActionResponse actionResponse, long assetListEntryId,
		long segmentsEntryId) {

		LiferayPortletResponse liferayPortletResponse =
			_portal.getLiferayPortletResponse(actionResponse);

		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/edit_asset_list_entry.jsp");
		portletURL.setParameter(
			"assetListEntryId", String.valueOf(assetListEntryId));
		portletURL.setParameter(
			"segmentsEntryId", String.valueOf(segmentsEntryId));

		return portletURL.toString();
	}

	@Reference
	private AssetListEntryService _assetListEntryService;

	@Reference
	private Portal _portal;

}