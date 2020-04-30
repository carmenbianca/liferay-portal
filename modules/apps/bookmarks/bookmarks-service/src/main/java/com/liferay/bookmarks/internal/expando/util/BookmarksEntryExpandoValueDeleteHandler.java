/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.expando.util;

import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.bookmarks.service.BookmarksEntryLocalService;
import com.liferay.expando.kernel.util.ExpandoValueDeleteHandler;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Máté Thurzó
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.bookmarks.model.BookmarksEntry",
	service = ExpandoValueDeleteHandler.class
)
public class BookmarksEntryExpandoValueDeleteHandler
	implements ExpandoValueDeleteHandler {

	@Override
	public void deletedExpandoValue(long classPK) {
		BookmarksEntry entry = _bookmarksEntryLocalService.fetchBookmarksEntry(
			classPK);

		if (entry == null) {
			return;
		}

		entry.setModifiedDate(new Date());

		_bookmarksEntryLocalService.updateBookmarksEntry(entry);
	}

	@Reference
	private BookmarksEntryLocalService _bookmarksEntryLocalService;

}