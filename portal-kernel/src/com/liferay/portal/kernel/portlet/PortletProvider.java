/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public interface PortletProvider {

	public String getPortletName();

	public PortletURL getPortletURL(HttpServletRequest httpServletRequest)
		throws PortalException;

	public PortletURL getPortletURL(
			HttpServletRequest httpServletRequest, Group group)
		throws PortalException;

	public enum Action {

		ADD, BROWSE, EDIT, MANAGE, PREVIEW, VIEW

	}

}