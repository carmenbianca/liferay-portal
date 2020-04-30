/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.servlet.taglib.clay;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.HorizontalCard;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.web.internal.display.context.JournalArticleItemSelectorViewDisplayContext;
import com.liferay.portal.kernel.util.HtmlUtil;

import javax.portlet.PortletURL;

/**
 * @author Eudaldo Alonso
 */
public class JournalFolderItemSelectorHorizontalCard implements HorizontalCard {

	public JournalFolderItemSelectorHorizontalCard(
		JournalFolder folder,
		JournalArticleItemSelectorViewDisplayContext
			journalArticleItemSelectorViewDisplayContext) {

		_folder = folder;
		_journalArticleItemSelectorViewDisplayContext =
			journalArticleItemSelectorViewDisplayContext;
	}

	@Override
	public String getElementClasses() {
		return "card-interactive card-interactive-secondary";
	}

	@Override
	public String getHref() {
		try {
			PortletURL rowURL =
				_journalArticleItemSelectorViewDisplayContext.getPortletURL();

			rowURL.setParameter(
				"folderId", String.valueOf(_folder.getFolderId()));

			return rowURL.toString();
		}
		catch (Exception exception) {
		}

		return null;
	}

	@Override
	public String getIcon() {
		return "folder";
	}

	@Override
	public String getTitle() {
		return HtmlUtil.escape(_folder.getName());
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	private final JournalFolder _folder;
	private final JournalArticleItemSelectorViewDisplayContext
		_journalArticleItemSelectorViewDisplayContext;

}