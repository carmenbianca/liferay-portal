/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.portlet.configuration.icon;

import com.liferay.configuration.admin.constants.ConfigurationAdminPortletKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;
import com.liferay.portal.kernel.portlet.configuration.icon.PortletConfigurationIcon;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jorge Ferrer
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + ConfigurationAdminPortletKeys.SYSTEM_SETTINGS,
	service = PortletConfigurationIcon.class
)
public class ExportAllConfigurationIcon extends BasePortletConfigurationIcon {

	@Override
	public String getMessage(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			themeDisplay.getLocale(), ExportAllConfigurationIcon.class);

		return LanguageUtil.get(resourceBundle, "export-all-settings");
	}

	@Override
	public String getMethod() {
		return "GET";
	}

	@Override
	public String getURL(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		LiferayPortletURL liferayPortletURL =
			(LiferayPortletURL)_portal.getControlPanelPortletURL(
				portletRequest, ConfigurationAdminPortletKeys.SYSTEM_SETTINGS,
				PortletRequest.RESOURCE_PHASE);

		liferayPortletURL.setResourceID("export");

		return liferayPortletURL.toString();
	}

	@Override
	public double getWeight() {
		return 1;
	}

	@Override
	public boolean isShow(PortletRequest portletRequest) {
		return true;
	}

	@Reference
	private Portal _portal;

}