/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.renderer;

import com.liferay.portal.kernel.exception.PortalException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Pavel Savinov
 */
public interface FragmentPortletRenderer {

	public String renderPortlet(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String portletName,
			String instanceId, String defaultPreferences)
		throws PortalException;

}