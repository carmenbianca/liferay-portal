/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.admin.web.internal.portlet;

import com.liferay.portal.kernel.portlet.ControlPanelEntry;
import com.liferay.portal.kernel.portlet.OmniadminControlPanelEntry;
import com.liferay.portal.search.admin.web.internal.constants.SearchAdminPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adam Brandizzi
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + SearchAdminPortletKeys.SEARCH_ADMIN,
	service = ControlPanelEntry.class
)
public class SearchAdminControlPanelEntry extends OmniadminControlPanelEntry {
}