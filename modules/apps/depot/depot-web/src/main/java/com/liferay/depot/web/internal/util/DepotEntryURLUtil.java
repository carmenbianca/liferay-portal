/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.util;

import com.liferay.depot.model.DepotEntry;
import com.liferay.depot.web.internal.constants.DepotPortletKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.taglib.security.PermissionsURLTag;

import javax.portlet.ActionRequest;
import javax.portlet.ActionURL;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Alejandro Tardín
 */
public class DepotEntryURLUtil {

	public static ActionURL getAddDepotEntryActionURL(
		String redirect, LiferayPortletResponse liferayPortletResponse) {

		ActionURL addDepotEntryURL = liferayPortletResponse.createActionURL();

		addDepotEntryURL.setParameter(
			ActionRequest.ACTION_NAME, "/depot/add_depot_entry");
		addDepotEntryURL.setParameter("redirect", redirect);

		return addDepotEntryURL;
	}

	public static ActionURL getDeleteDepotEntryActionURL(
		long depotEntryId, String redirect,
		LiferayPortletResponse liferayPortletResponse) {

		ActionURL deleteDepotEntryActionURL =
			liferayPortletResponse.createActionURL();

		deleteDepotEntryActionURL.setParameter(
			ActionRequest.ACTION_NAME, "/depot/delete_depot_entry");
		deleteDepotEntryActionURL.setParameter("redirect", redirect);
		deleteDepotEntryActionURL.setParameter(
			"depotEntryId", String.valueOf(depotEntryId));

		return deleteDepotEntryActionURL;
	}

	public static String getDepotEntryPermissionsURL(
			DepotEntry depotEntry, LiferayPortletRequest liferayPortletRequest)
		throws Exception {

		Group group = depotEntry.getGroup();

		return PermissionsURLTag.doTag(
			StringPool.BLANK, DepotEntry.class.getName(), group.getName(), null,
			String.valueOf(depotEntry.getDepotEntryId()),
			LiferayWindowState.POP_UP.toString(), null,
			liferayPortletRequest.getHttpServletRequest());
	}

	public static ActionURL getDisconnectSiteActionURL(
		long depotEntryGroupRelId, String redirect,
		LiferayPortletResponse liferayPortletResponse) {

		ActionURL disconnectSiteActionURL =
			liferayPortletResponse.createActionURL();

		disconnectSiteActionURL.setParameter(
			ActionRequest.ACTION_NAME, "/depot/disconnect_depot_entry");
		disconnectSiteActionURL.setParameter("redirect", redirect);
		disconnectSiteActionURL.setParameter(
			"depotEntryGroupRelId", String.valueOf(depotEntryGroupRelId));

		return disconnectSiteActionURL;
	}

	public static PortletURL getEditDepotEntryPortletURL(
		DepotEntry depotEntry, String redirect,
		LiferayPortletRequest liferayPortletRequest) {

		PortletURL editDepotEntryURL = PortalUtil.getControlPanelPortletURL(
			liferayPortletRequest, DepotPortletKeys.DEPOT_ADMIN,
			PortletRequest.RENDER_PHASE);

		editDepotEntryURL.setParameter(
			"mvcRenderCommandName", "/depot/edit_depot_entry");
		editDepotEntryURL.setParameter("redirect", redirect);
		editDepotEntryURL.setParameter(
			"depotEntryId", String.valueOf(depotEntry.getDepotEntryId()));

		return editDepotEntryURL;
	}

	public static ActionURL getUpdateSearchableActionURL(
		long depotEntryGroupRelId, boolean searchable, String redirect,
		LiferayPortletResponse liferayPortletResponse) {

		ActionURL updateSearchableActionURL =
			liferayPortletResponse.createActionURL();

		updateSearchableActionURL.setParameter(
			ActionRequest.ACTION_NAME,
			"/depot/update_depot_entry_group_rel_searchable");
		updateSearchableActionURL.setParameter("redirect", redirect);
		updateSearchableActionURL.setParameter(
			"depotEntryGroupRelId", String.valueOf(depotEntryGroupRelId));
		updateSearchableActionURL.setParameter(
			"searchable", String.valueOf(searchable));

		return updateSearchableActionURL;
	}

}