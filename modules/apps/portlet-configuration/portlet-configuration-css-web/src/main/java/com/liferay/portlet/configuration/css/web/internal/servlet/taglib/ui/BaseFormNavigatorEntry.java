/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.configuration.css.web.internal.servlet.taglib.ui;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.servlet.taglib.ui.BaseJSPFormNavigatorEntry;
import com.liferay.portlet.configuration.css.web.internal.constants.PortletConfigurationCSSConstants;

import java.util.Locale;

/**
 * @author Eudaldo Alonso
 */
public abstract class BaseFormNavigatorEntry
	extends BaseJSPFormNavigatorEntry<Layout> {

	@Override
	public String getCategoryKey() {
		return StringPool.BLANK;
	}

	@Override
	public String getFormNavigatorId() {
		return PortletConfigurationCSSConstants.FORM_NAVIGATOR_ID;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, getKey());
	}

}