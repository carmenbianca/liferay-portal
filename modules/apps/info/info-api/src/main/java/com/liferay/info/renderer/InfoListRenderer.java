/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.renderer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author     Jorge Ferrer
 * @deprecated As of Mueller (7.2.x), moved to {@link
 *             com.liferay.info.list.renderer.InfoListRenderer}
 */
@Deprecated
public interface InfoListRenderer<T> {

	public default String getKey() {
		Class<?> clazz = getClass();

		return clazz.getName();
	}

	public void render(
		List<T> list, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse);

}