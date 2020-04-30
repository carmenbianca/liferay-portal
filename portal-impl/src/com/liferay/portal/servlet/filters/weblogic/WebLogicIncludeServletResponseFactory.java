/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.weblogic;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Shuyang Zhou
 */
public interface WebLogicIncludeServletResponseFactory {

	public HttpServletResponse create(HttpServletResponse httpServletResponse);

}