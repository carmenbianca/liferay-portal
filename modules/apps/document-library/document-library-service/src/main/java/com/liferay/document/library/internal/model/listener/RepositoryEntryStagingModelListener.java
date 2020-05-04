/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.RepositoryEntry;
import com.liferay.staging.model.listener.StagingModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(service = ModelListener.class)
public class RepositoryEntryStagingModelListener
	extends BaseModelListener<RepositoryEntry> {

	@Override
	public void onAfterCreate(RepositoryEntry repositoryEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(repositoryEntry);
	}

	@Override
	public void onAfterRemove(RepositoryEntry repositoryEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(repositoryEntry);
	}

	@Override
	public void onAfterUpdate(RepositoryEntry repositoryEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(repositoryEntry);
	}

	@Reference
	private StagingModelListener<RepositoryEntry> _stagingModelListener;

}