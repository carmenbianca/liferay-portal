/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.sso;

import java.io.IOException;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Michael C. Han
 */
public interface OpenSSO {

	public Map<String, String> getAttributes(
		HttpServletRequest httpServletRequest, String serviceUrl);

	public String getSubjectId(
		HttpServletRequest httpServletRequest, String serviceUrl);

	public boolean isAuthenticated(
			HttpServletRequest httpServletRequest, String serviceUrl)
		throws IOException;

	public boolean isValidServiceUrl(String serviceUrl);

	public boolean isValidUrl(String url);

	public boolean isValidUrls(String[] urls);

}