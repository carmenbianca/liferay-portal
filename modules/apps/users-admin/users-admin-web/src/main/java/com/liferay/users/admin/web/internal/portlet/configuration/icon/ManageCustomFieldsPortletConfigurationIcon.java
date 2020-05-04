/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.portlet.configuration.icon;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;
import com.liferay.portal.kernel.portlet.configuration.icon.PortletConfigurationIcon;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.users.admin.constants.UsersAdminPortletKeys;

import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

/**
 * @author Albert Lee
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + UsersAdminPortletKeys.USERS_ADMIN,
	service = PortletConfigurationIcon.class
)
public class ManageCustomFieldsPortletConfigurationIcon
	extends BasePortletConfigurationIcon {

	@Override
	public String getMessage(PortletRequest portletRequest) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", getLocale(portletRequest), getClass());

		return LanguageUtil.get(resourceBundle, "manage-custom-fields");
	}

	@Override
	public String getURL(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			PortletURL portletURL = PortletProviderUtil.getPortletURL(
				portletRequest, ExpandoColumn.class.getName(),
				PortletProvider.Action.MANAGE);

			portletURL.setParameter("modelResource", User.class.getName());
			portletURL.setParameter("redirect", themeDisplay.getURLCurrent());

			return portletURL.toString();
		}
		catch (Exception exception) {
		}

		return StringPool.BLANK;
	}

	@Override
	public double getWeight() {
		return 100;
	}

	@Override
	public boolean isShow(PortletRequest portletRequest) {
		String usersListView = ParamUtil.get(
			portletRequest, "usersListView",
			UserConstants.LIST_VIEW_FLAT_USERS);

		if (!usersListView.equals(UserConstants.LIST_VIEW_FLAT_USERS)) {
			return false;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			if (PortletPermissionUtil.contains(
					themeDisplay.getPermissionChecker(), PortletKeys.EXPANDO,
					ActionKeys.ACCESS_IN_CONTROL_PANEL)) {

				return true;
			}
		}
		catch (Exception exception) {
		}

		return false;
	}

}