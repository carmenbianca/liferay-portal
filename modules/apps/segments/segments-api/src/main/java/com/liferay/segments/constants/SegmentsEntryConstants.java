/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.constants;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Eduardo García
 */
public class SegmentsEntryConstants {

	public static final long ID_DEFAULT = 0;

	public static final String KEY_DEFAULT = "DEFAULT";

	public static final String SOURCE_ASAH_FARO_BACKEND = "ASAH_FARO_BACKEND";

	public static final String SOURCE_DEFAULT = "DEFAULT";

	public static final String SOURCE_REFERRED = "REFERRED";

	public static String getDefaultSegmentsEntryName(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, SegmentsEntryConstants.class);

		return LanguageUtil.get(resourceBundle, "default-segment-name");
	}

}