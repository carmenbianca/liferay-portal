/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.renderer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author     Jorge Ferrer
 * @deprecated As of Mueller (7.2.x), moved to {@link
 *             com.liferay.info.item.renderer.InfoItemRenderer}
 */
@Deprecated
public interface InfoItemRenderer<T> {

	public default String getKey() {
		Class<?> clazz = getClass();

		return clazz.getName();
	}

	public void render(
		T t, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse);

}