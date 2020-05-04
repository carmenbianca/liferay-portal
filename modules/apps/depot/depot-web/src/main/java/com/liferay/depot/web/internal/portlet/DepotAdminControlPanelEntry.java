/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.portlet;

import com.liferay.depot.web.internal.constants.DepotPortletKeys;
import com.liferay.portal.kernel.portlet.BaseControlPanelEntry;
import com.liferay.portal.kernel.portlet.ControlPanelEntry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + DepotPortletKeys.DEPOT_ADMIN,
	service = ControlPanelEntry.class
)
public class DepotAdminControlPanelEntry extends BaseControlPanelEntry {
}