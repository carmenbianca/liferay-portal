/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.validhostname;

import com.liferay.portal.kernel.servlet.TryFilter;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shuyang Zhou
 */
public class ValidHostNameFilter extends BasePortalFilter implements TryFilter {

	@Override
	public Object doFilterTry(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		String serverName = httpServletRequest.getServerName();

		String validPortalDomain = PortalUtil.getValidPortalDomain(
			PortalUtil.getDefaultCompanyId(), serverName);

		if (!StringUtil.equalsIgnoreCase(serverName, validPortalDomain)) {
			throw new RuntimeException("Invalid host name " + serverName);
		}

		return null;
	}

}