/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gogo.shell.web.internal.portlet;

import com.liferay.gogo.shell.web.internal.constants.GogoShellPortletKeys;
import com.liferay.portal.kernel.portlet.ControlPanelEntry;
import com.liferay.portal.kernel.portlet.OmniadminControlPanelEntry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tomas Polesovsky
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + GogoShellPortletKeys.GOGO_SHELL,
	service = ControlPanelEntry.class
)
public class GogoShellControlPanelEntry extends OmniadminControlPanelEntry {
}