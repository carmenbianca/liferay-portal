/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet;

import com.liferay.portal.kernel.portlet.LiferayHeaderResponse;
import com.liferay.portlet.internal.HeaderRequestImpl;
import com.liferay.portlet.internal.HeaderResponseImpl;

import javax.portlet.HeaderRequest;
import javax.portlet.filter.HeaderRequestWrapper;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Neil Griffin
 */
public class HeaderResponseFactory {

	public static LiferayHeaderResponse create(
		HeaderRequest headerRequest, HttpServletResponse httpServletResponse) {

		while (headerRequest instanceof HeaderRequestWrapper) {
			HeaderRequestWrapper headerRequestWrapper =
				(HeaderRequestWrapper)headerRequest;

			headerRequest = headerRequestWrapper.getRequest();
		}

		HeaderResponseImpl headerResponseImpl = new HeaderResponseImpl();

		headerResponseImpl.init(
			(HeaderRequestImpl)headerRequest, httpServletResponse);

		return headerResponseImpl;
	}

}