/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.admin.web.internal.portlet;

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ManagePortletProvider;
import com.liferay.site.admin.web.internal.constants.SiteAdminPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.portal.kernel.model.Group",
	service = ManagePortletProvider.class
)
public class SiteAdminManagePortletProvider
	extends BasePortletProvider implements ManagePortletProvider {

	@Override
	public String getPortletName() {
		return SiteAdminPortletKeys.SITE_ADMIN;
	}

}