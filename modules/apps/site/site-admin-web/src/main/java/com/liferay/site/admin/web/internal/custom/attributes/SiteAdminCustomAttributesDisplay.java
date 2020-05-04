/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.admin.web.internal.custom.attributes;

import com.liferay.expando.kernel.model.BaseCustomAttributesDisplay;
import com.liferay.expando.kernel.model.CustomAttributesDisplay;
import com.liferay.portal.kernel.model.Group;
import com.liferay.site.admin.web.internal.constants.SiteAdminPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jorge Ferrer
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + SiteAdminPortletKeys.SITE_ADMIN,
	service = CustomAttributesDisplay.class
)
public class SiteAdminCustomAttributesDisplay
	extends BaseCustomAttributesDisplay {

	@Override
	public String getClassName() {
		return Group.class.getName();
	}

	@Override
	public String getIconCssClass() {
		return "sites";
	}

}