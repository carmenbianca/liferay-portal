/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.ColorScheme;
import com.liferay.portal.kernel.util.ColorSchemeFactory;
import com.liferay.portal.model.impl.ColorSchemeImpl;

/**
 * @author Vilmos Papp
 */
public class ColorSchemeFactoryImpl implements ColorSchemeFactory {

	@Override
	public ColorScheme getColorScheme() {
		return new ColorSchemeImpl();
	}

	@Override
	public ColorScheme getColorScheme(String colorSchemeId) {
		return new ColorSchemeImpl(colorSchemeId);
	}

	@Override
	public ColorScheme getColorScheme(
		String colorSchemeId, String name, String cssClass) {

		return new ColorSchemeImpl(colorSchemeId, name, cssClass);
	}

	@Override
	public ColorScheme getDefaultRegularColorScheme() {
		return new ColorSchemeImpl(
			getDefaultRegularColorSchemeId(), StringPool.BLANK,
			StringPool.BLANK);
	}

	@Override
	public String getDefaultRegularColorSchemeId() {
		return PropsValues.DEFAULT_REGULAR_COLOR_SCHEME_ID;
	}

}