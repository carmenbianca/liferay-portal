/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.jsoncontenttype;

import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringUtil;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author Hugo Huijser
 * @author Igor Spasic
 */
public class JSONContentTypeResponse extends HttpServletResponseWrapper {

	public JSONContentTypeResponse(HttpServletResponse httpServletResponse) {
		super(httpServletResponse);
	}

	@Override
	public void setContentType(String contentType) {
		if (StringUtil.equalsIgnoreCase(
				contentType, ContentTypes.APPLICATION_JSON)) {

			contentType = ContentTypes.TEXT_JAVASCRIPT;
		}

		super.setContentType(contentType);
	}

}