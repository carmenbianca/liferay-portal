/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Carlos Sierra Andrés
 */
public interface TagDynamicInclude {

	public void include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String tagClassName,
			String tagDynamicId, String tagPoint)
		throws IOException;

	public void register(TagDynamicIncludeRegistry tagDynamicIncludeRegistry);

	public interface TagDynamicIncludeRegistry {

		public void register(
			String tagClassName, String tagDynamicId, String tagPoint);

	}

}