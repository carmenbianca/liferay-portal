/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.display.url.provider;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public interface InfoEditURLProvider<T> {

	public String getURL(T t, HttpServletRequest httpServletRequest)
		throws Exception;

}