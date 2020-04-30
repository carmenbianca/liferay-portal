/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.item.renderer;

import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jorge Ferrer
 */
public interface InfoItemRenderer<T> {

	public default String getKey() {
		Class<?> clazz = getClass();

		return clazz.getName();
	}

	public default String getLabel(Locale locale) {
		return LanguageUtil.get(locale, getKey());
	}

	public void render(
		T t, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse);

}