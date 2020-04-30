/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.instances.web.internal.portlet;

import com.liferay.portal.instances.web.internal.constants.PortalInstancesPortletKeys;
import com.liferay.portal.kernel.portlet.ControlPanelEntry;
import com.liferay.portal.kernel.portlet.OmniadminControlPanelEntry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alan Huang
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + PortalInstancesPortletKeys.PORTAL_INSTANCES,
	service = ControlPanelEntry.class
)
public class PortalInstancesControlPanelEntry
	extends OmniadminControlPanelEntry {
}