/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.license.manager.web.internal.portlet;

import com.liferay.license.manager.web.internal.constants.LicenseManagerPortletKeys;
import com.liferay.portal.kernel.portlet.ControlPanelEntry;
import com.liferay.portal.kernel.portlet.OmniadminControlPanelEntry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Daniel Sanz
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + LicenseManagerPortletKeys.LICENSE_MANAGER,
	service = ControlPanelEntry.class
)
public class LicenseManagerControlPanelEntry
	extends OmniadminControlPanelEntry {
}