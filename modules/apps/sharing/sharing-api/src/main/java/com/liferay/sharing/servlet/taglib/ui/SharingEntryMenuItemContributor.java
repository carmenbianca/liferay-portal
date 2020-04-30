/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.servlet.taglib.ui;

import com.liferay.portal.kernel.servlet.taglib.ui.MenuItem;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.sharing.model.SharingEntry;

import java.util.Collection;

/**
 * @author Adolfo Pérez
 */
public interface SharingEntryMenuItemContributor {

	public Collection<MenuItem> getSharingEntryMenuItems(
		SharingEntry sharingEntry, ThemeDisplay themeDisplay);

}