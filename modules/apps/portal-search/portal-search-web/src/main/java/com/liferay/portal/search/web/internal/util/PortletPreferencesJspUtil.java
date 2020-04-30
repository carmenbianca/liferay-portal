/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.settings.ParameterMapSettings;

/**
 * @author André de Oliveira
 */
public class PortletPreferencesJspUtil {

	public static String getInputName(String key) {
		return ParameterMapSettings.PREFERENCES_PREFIX + key +
			StringPool.DOUBLE_DASH;
	}

}