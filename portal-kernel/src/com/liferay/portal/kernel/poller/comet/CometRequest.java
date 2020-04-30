/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.poller.comet;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Edward Han
 * @author Brian Wing Shun Chan
 */
public interface CometRequest {

	public long getCompanyId();

	public String getParameter(String name);

	public Map<String, String[]> getParameterMap();

	public Enumeration<String> getParameterNames();

	public String getPathInfo();

	public HttpServletRequest getRequest();

	public long getTimestamp();

	public long getUserId();

	public void setCompanyId(long companyId);

	public void setPathInfo(String pathInfo);

	public void setTimestamp(long timestamp);

	public void setUserId(long userId);

}