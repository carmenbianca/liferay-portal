/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.configuration.css.web.internal.servlet.taglib.ui;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorCategory;
import com.liferay.portlet.configuration.css.web.internal.constants.PortletConfigurationCSSConstants;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	property = "form.navigator.category.order:Integer=50",
	service = FormNavigatorCategory.class
)
public class TextStylesFormNavigatorCategory implements FormNavigatorCategory {

	@Override
	public String getFormNavigatorId() {
		return PortletConfigurationCSSConstants.FORM_NAVIGATOR_ID;
	}

	@Override
	public String getKey() {
		return PortletConfigurationCSSConstants.CATEGORY_KEY_TEXT_STYLES;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "text-styles");
	}

}