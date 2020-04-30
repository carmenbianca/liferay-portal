/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.util.comparator;

import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryModifiedDateComparator
	extends StagedModelModifiedDateComparator<BookmarksEntry> {

	public EntryModifiedDateComparator() {
		this(false);
	}

	public EntryModifiedDateComparator(boolean ascending) {
		super(ascending);
	}

}