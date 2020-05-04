/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Amos Fong
 */
public interface AuthToken {

	public void addCSRFToken(
		HttpServletRequest httpServletRequest,
		LiferayPortletURL liferayPortletURL);

	public void addPortletInvocationToken(
		HttpServletRequest httpServletRequest,
		LiferayPortletURL liferayPortletURL);

	public void checkCSRFToken(
			HttpServletRequest httpServletRequest, String origin)
		throws PrincipalException;

	public String getToken(HttpServletRequest httpServletRequest);

	public String getToken(
		HttpServletRequest httpServletRequest, long plid, String portletId);

	public boolean isValidPortletInvocationToken(
		HttpServletRequest httpServletRequest, Layout layout, Portlet portlet);

}