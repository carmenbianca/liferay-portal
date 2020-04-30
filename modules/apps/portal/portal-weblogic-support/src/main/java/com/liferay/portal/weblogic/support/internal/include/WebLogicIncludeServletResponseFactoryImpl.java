/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.weblogic.support.internal.include;

import com.liferay.portal.servlet.filters.weblogic.WebLogicIncludeServletResponseFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Shuyang Zhou
 */
public class WebLogicIncludeServletResponseFactoryImpl
	implements WebLogicIncludeServletResponseFactory {

	@Override
	public HttpServletResponse create(HttpServletResponse httpServletResponse) {
		if (httpServletResponse instanceof WebLogicIncludeServletResponse) {
			return httpServletResponse;
		}

		return new WebLogicIncludeServletResponse(httpServletResponse);
	}

}