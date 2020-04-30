/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.model.Theme;

/**
 * @author Harrison Schueler
 */
public interface ThemeFactory {

	public Theme getDefaultRegularTheme(long companyId);

	public String getDefaultRegularThemeId(long companyId);

	public Theme getTheme();

	public Theme getTheme(String themeId);

	public Theme getTheme(String themeId, String name);

}