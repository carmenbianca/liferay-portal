/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.display.context;

import com.liferay.portal.kernel.theme.ThemeDisplay;

/**
 * @author André de Oliveira
 */
public interface ThemeDisplaySupplier {

	public ThemeDisplay getThemeDisplay();

}