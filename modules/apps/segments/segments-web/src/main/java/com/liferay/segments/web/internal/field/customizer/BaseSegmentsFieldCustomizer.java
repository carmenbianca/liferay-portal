/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.web.internal.field.customizer;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.segments.field.customizer.SegmentsFieldCustomizer;

import java.util.Locale;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BaseSegmentsFieldCustomizer
	implements SegmentsFieldCustomizer {

	protected String getSelectEntityTitle(Locale locale, String className) {
		String title = ResourceActionsUtil.getModelResource(locale, className);

		return LanguageUtil.format(locale, "select-x", title);
	}

}