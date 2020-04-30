/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.servlet.taglib;

import com.liferay.portal.kernel.model.User;

import java.io.IOException;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eudaldo Alonso
 */
public interface ScreenNavigationEntry<T> {

	public String getCategoryKey();

	public String getEntryKey();

	public String getLabel(Locale locale);

	public String getScreenNavigationKey();

	public default boolean isVisible(User user, T context) {
		return true;
	}

	public void render(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException;

}