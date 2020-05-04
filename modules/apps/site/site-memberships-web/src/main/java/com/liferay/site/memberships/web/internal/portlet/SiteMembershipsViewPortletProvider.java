/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.memberships.web.internal.portlet;

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;
import com.liferay.site.memberships.constants.SiteMembershipsPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.portal.kernel.model.MembershipRequest",
	service = ViewPortletProvider.class
)
public class SiteMembershipsViewPortletProvider
	extends BasePortletProvider implements ViewPortletProvider {

	@Override
	public String getPortletName() {
		return SiteMembershipsPortletKeys.SITE_MEMBERSHIPS_ADMIN;
	}

}