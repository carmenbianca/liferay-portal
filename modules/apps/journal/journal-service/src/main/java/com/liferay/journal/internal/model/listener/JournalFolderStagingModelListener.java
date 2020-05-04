/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.model.listener;

import com.liferay.journal.model.JournalFolder;
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
public class JournalFolderStagingModelListener
	extends BaseModelListener<JournalFolder> {

	@Override
	public void onAfterCreate(JournalFolder journalFolder)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(journalFolder);
	}

	@Override
	public void onAfterRemove(JournalFolder journalFolder)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(journalFolder);
	}

	@Override
	public void onAfterUpdate(JournalFolder journalFolder)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(journalFolder);
	}

	@Reference
	private StagingModelListener<JournalFolder> _stagingModelListener;

}