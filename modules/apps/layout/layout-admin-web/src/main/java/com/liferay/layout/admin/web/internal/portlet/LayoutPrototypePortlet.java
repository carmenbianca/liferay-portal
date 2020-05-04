/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.portlet;

import com.liferay.layout.prototype.constants.LayoutPrototypePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"javax.portlet.name=" + LayoutPrototypePortletKeys.LAYOUT_PROTOTYPE,
		"javax.portlet.resource-bundle=content.Language"
	},
	service = Portlet.class
)
public class LayoutPrototypePortlet extends MVCPortlet {
}