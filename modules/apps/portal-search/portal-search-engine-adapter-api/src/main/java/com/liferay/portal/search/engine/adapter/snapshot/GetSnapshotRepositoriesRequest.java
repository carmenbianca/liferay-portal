/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.snapshot;

import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

/**
 * @author Michael C. Han
 */
public class GetSnapshotRepositoriesRequest
	extends CrossClusterRequest
	implements SnapshotRequest<GetSnapshotRepositoriesResponse> {

	public GetSnapshotRepositoriesRequest(String... repositoryNames) {
		_repositoryNames = repositoryNames;
	}

	@Override
	public GetSnapshotRepositoriesResponse accept(
		SnapshotRequestExecutor snapshotRequestExecutor) {

		return snapshotRequestExecutor.executeSnapshotRequest(this);
	}

	public String[] getRepositoryNames() {
		return _repositoryNames;
	}

	private final String[] _repositoryNames;

}