/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.servlet.taglib.ui;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorCategory;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorConstants;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	property = "form.navigator.category.order:Integer=20",
	service = FormNavigatorCategory.class
)
public class LayoutSetLookAndFeelFormNavigatorCategory
	implements FormNavigatorCategory {

	@Override
	public String getFormNavigatorId() {
		return FormNavigatorConstants.FORM_NAVIGATOR_ID_LAYOUT_SET;
	}

	@Override
	public String getKey() {
		return FormNavigatorConstants.CATEGORY_KEY_LAYOUT_SET_LOOK_AND_FEEL;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "look-and-feel");
	}

}