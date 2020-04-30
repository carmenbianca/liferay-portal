/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webdav.methods;

import com.liferay.portal.kernel.webdav.WebDAVException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Fabio Pezzutto
 */
public interface MethodFactory {

	public Method create(HttpServletRequest httpServletRequest)
		throws WebDAVException;

}