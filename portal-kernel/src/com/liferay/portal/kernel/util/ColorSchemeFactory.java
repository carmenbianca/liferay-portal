/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.model.ColorScheme;

/**
 * @author Vilmos Papp
 */
public interface ColorSchemeFactory {

	public ColorScheme getColorScheme();

	public ColorScheme getColorScheme(String colorSchemeId);

	public ColorScheme getColorScheme(
		String colorSchemeId, String name, String cssClass);

	public ColorScheme getDefaultRegularColorScheme();

	public String getDefaultRegularColorSchemeId();

}