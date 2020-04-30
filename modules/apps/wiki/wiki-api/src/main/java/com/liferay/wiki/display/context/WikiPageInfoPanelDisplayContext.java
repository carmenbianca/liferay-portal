/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.display.context;

import com.liferay.wiki.model.WikiPage;

/**
 * @author Roberto Díaz
 */
public interface WikiPageInfoPanelDisplayContext extends WikiDisplayContext {

	public WikiPage getFirstPage();

	public String getPageRSSURL(WikiPage page);

	public int getPagesCount();

	public int getSelectedPagesCount();

	public boolean isMultiplePageSelection();

	public boolean isShowSidebarHeader();

	public boolean isSinglePageSelection();

}