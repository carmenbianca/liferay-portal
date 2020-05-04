/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.web.internal.portlet;

import com.liferay.adaptive.media.web.internal.constants.AMPortletKeys;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.ControlPanelEntry;
import com.liferay.portal.kernel.portlet.OmniadminControlPanelEntry;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alan Huang
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + AMPortletKeys.ADAPTIVE_MEDIA,
	service = ControlPanelEntry.class
)
public class AMControlPanelEntry extends OmniadminControlPanelEntry {

	@Override
	public boolean hasAccessPermission(
			PermissionChecker permissionChecker, Group group, Portlet portlet)
		throws Exception {

		if (super.hasAccessPermission(permissionChecker, group, portlet)) {
			return true;
		}

		return permissionChecker.isCompanyAdmin();
	}

}