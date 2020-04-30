/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.engine.adapter.snapshot.CreateSnapshotRepositoryRequest;
import com.liferay.portal.search.engine.adapter.snapshot.CreateSnapshotRepositoryResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(
	immediate = true, service = CreateSnapshotRepositoryRequestExecutor.class
)
public class CreateSnapshotRepositoryRequestExecutorImpl
	implements CreateSnapshotRepositoryRequestExecutor {

	@Override
	public CreateSnapshotRepositoryResponse execute(
		CreateSnapshotRepositoryRequest createSnapshotRepositoryRequest) {

		throw new UnsupportedOperationException();
	}

}