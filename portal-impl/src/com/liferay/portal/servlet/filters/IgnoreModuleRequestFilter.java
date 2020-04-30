/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters;

import com.liferay.portal.kernel.util.PortalUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Raymond Augé
 */
public abstract class IgnoreModuleRequestFilter extends BasePortalFilter {

	@Override
	public boolean isFilterEnabled(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		if (isModuleRequest(httpServletRequest)) {
			return false;
		}

		return super.isFilterEnabled(httpServletRequest, httpServletResponse);
	}

	protected boolean isModuleRequest(HttpServletRequest httpServletRequest) {
		String contextPath = httpServletRequest.getContextPath();

		String requestURI = httpServletRequest.getRequestURI();

		String resourcePath = requestURI;

		int index = requestURI.indexOf(contextPath);

		if (index == 0) {
			resourcePath = resourcePath.substring(contextPath.length());
		}

		if (resourcePath.startsWith(_MODULE_REQUEST_PREFIX)) {
			return true;
		}

		return false;
	}

	private static final String _MODULE_REQUEST_PREFIX =
		PortalUtil.getPathModule() + "/";

}