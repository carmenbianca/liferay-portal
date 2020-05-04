/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.servlet.taglib;

import com.liferay.depot.web.internal.constants.DepotScreenNavigationEntryConstants;
import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = "screen.navigation.entry.order:Integer=2",
	service = ScreenNavigationEntry.class
)
public class LanguagesScreenNavigationEntry
	extends BaseDepotScreenNavigationEntry {

	@Override
	public String getActionCommandName() {
		return "/depot/edit_depot_entry";
	}

	@Override
	public String getEntryKey() {
		return DepotScreenNavigationEntryConstants.ENTRY_KEY_LANGUAGES;
	}

	@Override
	public String getJspPath() {
		return "/screen/navigation/entries/languages.jsp";
	}

}