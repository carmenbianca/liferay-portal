/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.theme;

import com.liferay.portal.kernel.theme.ThemeDisplay;

/**
 * @author Brian Wing Shun Chan
 */
public class ThemeDisplayFactory {

	public static ThemeDisplay create() {
		return new ThemeDisplay();
	}

}