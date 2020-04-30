/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.servlet.taglib;

import java.util.Locale;

/**
 * @author Eudaldo Alonso
 */
public interface ScreenNavigationCategory {

	public String getCategoryKey();

	public String getLabel(Locale locale);

	public String getScreenNavigationKey();

}