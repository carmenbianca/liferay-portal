/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.model.listener;

import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.staging.model.listener.StagingModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true, service = ModelListener.class)
public class BookmarksEntryStagingModelListener
	extends BaseModelListener<BookmarksEntry> {

	@Override
	public void onAfterCreate(BookmarksEntry bookmarksEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(bookmarksEntry);
	}

	@Override
	public void onAfterRemove(BookmarksEntry bookmarksEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(bookmarksEntry);
	}

	@Override
	public void onAfterUpdate(BookmarksEntry bookmarksEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(bookmarksEntry);
	}

	@Reference
	private StagingModelListener<BookmarksEntry> _stagingModelListener;

}