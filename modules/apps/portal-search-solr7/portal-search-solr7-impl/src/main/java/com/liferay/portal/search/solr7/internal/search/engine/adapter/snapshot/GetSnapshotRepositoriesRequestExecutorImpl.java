/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.engine.adapter.snapshot.GetSnapshotRepositoriesRequest;
import com.liferay.portal.search.engine.adapter.snapshot.GetSnapshotRepositoriesResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(
	immediate = true, service = GetSnapshotRepositoriesRequestExecutor.class
)
public class GetSnapshotRepositoriesRequestExecutorImpl
	implements GetSnapshotRepositoriesRequestExecutor {

	@Override
	public GetSnapshotRepositoriesResponse execute(
		GetSnapshotRepositoriesRequest getSnapshotRepositoriesRequest) {

		throw new UnsupportedOperationException();
	}

}