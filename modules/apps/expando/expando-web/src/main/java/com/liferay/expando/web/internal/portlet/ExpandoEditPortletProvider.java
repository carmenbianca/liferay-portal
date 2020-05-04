/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.web.internal.portlet;

import com.liferay.expando.constants.ExpandoPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.EditPortletProvider;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Albert Lee
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.expando.kernel.model.ExpandoColumn",
	service = EditPortletProvider.class
)
public class ExpandoEditPortletProvider
	extends BasePortletProvider implements EditPortletProvider {

	@Override
	public String getPortletName() {
		return ExpandoPortletKeys.EXPANDO;
	}

	@Override
	public PortletURL getPortletURL(HttpServletRequest httpServletRequest)
		throws PortalException {

		PortletURL portletURL = super.getPortletURL(httpServletRequest);

		portletURL.setParameter("mvcPath", "/edit/select_field_type.jsp");

		return portletURL;
	}

}