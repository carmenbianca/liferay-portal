/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.internal.servlet.taglib.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Drew Brokke
 */
public class ManagementToolbarDefaults {

	public static String getContentRenderer() {
		return "hiddenInputsForm";
	}

	public static String getSearchFormMethod() {
		return "GET";
	}

	public static String getSearchInputName() {
		return DisplayTerms.KEYWORDS;
	}

	public static Boolean isShowCreationMenu(CreationMenu creationMenu) {
		if (creationMenu != null) {
			return true;
		}

		return false;
	}

	public static Boolean isShowInfoButton(String infoPanelId) {
		return Validator.isNotNull(infoPanelId);
	}

}