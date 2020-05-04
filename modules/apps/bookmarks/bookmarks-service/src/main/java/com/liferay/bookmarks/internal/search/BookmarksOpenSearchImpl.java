/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.search;

import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.OpenSearch;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(service = OpenSearch.class)
public class BookmarksOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String TITLE = "Liferay Bookmarks Search: ";

	@Override
	public String getClassName() {
		return BookmarksEntry.class.getName();
	}

	@Override
	public Indexer<BookmarksEntry> getIndexer() {
		return IndexerRegistryUtil.getIndexer(BookmarksEntry.class);
	}

	@Override
	public String getSearchPath() {
		return StringPool.BLANK;
	}

	@Override
	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

}