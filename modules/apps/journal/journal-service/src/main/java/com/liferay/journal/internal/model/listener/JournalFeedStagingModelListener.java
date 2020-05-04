/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.model.listener;

import com.liferay.journal.model.JournalFeed;
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
public class JournalFeedStagingModelListener
	extends BaseModelListener<JournalFeed> {

	@Override
	public void onAfterCreate(JournalFeed journalFeed)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(journalFeed);
	}

	@Override
	public void onAfterRemove(JournalFeed journalFeed)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(journalFeed);
	}

	@Override
	public void onAfterUpdate(JournalFeed journalFeed)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(journalFeed);
	}

	@Reference
	private StagingModelListener<JournalFeed> _stagingModelListener;

}