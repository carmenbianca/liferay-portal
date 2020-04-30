/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.content.page.editor.sidebar.panel;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public interface ContentPageEditorSidebarPanel {

	public String getIcon();

	public String getId();

	public String getLabel(Locale locale);

	public default String getURL(HttpServletRequest httpServletRequest) {
		return null;
	}

	public default boolean includeSeparator() {
		return false;
	}

	public default boolean isLink() {
		return false;
	}

	public default boolean isVisible(boolean pageIsDisplayPage) {
		return true;
	}

	public default boolean isVisible(
		PermissionChecker permissionChecker, long plid,
		boolean pageIsDisplayPage) {

		return true;
	}

}