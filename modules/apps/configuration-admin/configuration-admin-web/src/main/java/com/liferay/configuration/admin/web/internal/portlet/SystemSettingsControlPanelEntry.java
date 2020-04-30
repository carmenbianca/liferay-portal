/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.portlet;

import com.liferay.configuration.admin.constants.ConfigurationAdminPortletKeys;
import com.liferay.portal.kernel.portlet.ControlPanelEntry;
import com.liferay.portal.kernel.portlet.OmniadminControlPanelEntry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alan Huang
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + ConfigurationAdminPortletKeys.SYSTEM_SETTINGS,
	service = ControlPanelEntry.class
)
public class SystemSettingsControlPanelEntry
	extends OmniadminControlPanelEntry {
}