/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Carlos Sierra Andrés
 */
public interface TagDynamicIdFactory {

	public String getTagDynamicId(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, Object tag);

}