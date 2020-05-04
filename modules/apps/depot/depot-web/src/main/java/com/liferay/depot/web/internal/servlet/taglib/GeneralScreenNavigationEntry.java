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
	property = "screen.navigation.entry.order:Integer=1",
	service = ScreenNavigationEntry.class
)
public class GeneralScreenNavigationEntry
	extends BaseDepotScreenNavigationEntry {

	@Override
	public String getActionCommandName() {
		return "/depot/edit_depot_entry";
	}

	@Override
	public String getEntryKey() {
		return DepotScreenNavigationEntryConstants.ENTRY_KEY_GENERAL;
	}

	@Override
	public String getJspPath() {
		return "/screen/navigation/entries/details.jsp";
	}

}