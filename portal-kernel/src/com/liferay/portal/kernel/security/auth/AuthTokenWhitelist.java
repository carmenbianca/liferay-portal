/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Tomas Polesovsky
 * @author Raymond Augé
 */
public interface AuthTokenWhitelist {

	public boolean isOriginCSRFWhitelisted(long companyId, String origin);

	public boolean isPortletCSRFWhitelisted(
		HttpServletRequest httpServletRequest, Portlet portlet);

	public boolean isPortletInvocationWhitelisted(
		HttpServletRequest httpServletRequest, Portlet portlet);

	public boolean isPortletURLCSRFWhitelisted(
		LiferayPortletURL liferayPortletURL);

	public boolean isPortletURLPortletInvocationWhitelisted(
		LiferayPortletURL liferayPortletURL);

	public boolean isValidSharedSecret(String sharedSecret);

}