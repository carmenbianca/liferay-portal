/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.web.internal.servlet.taglib.ui;

import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;
import com.liferay.layout.seo.web.internal.constants.LayoutSEOScreenNavigationEntryConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alicia Garcia
 */
@Component(
	property = "screen.navigation.entry.order:Integer=3",
	service = ScreenNavigationEntry.class
)
public class LayoutCustomMetaTagsScreenNavigationEntry
	extends BaseLayoutScreenNavigationEntry {

	@Override
	public String getEntryKey() {
		return LayoutSEOScreenNavigationEntryConstants.
			ENTRY_KEY_CUSTOM_META_TAGS;
	}

	@Override
	protected String getJspPath() {
		return "/layout/screen/navigation/entries/custom_meta_tags.jsp";
	}

}