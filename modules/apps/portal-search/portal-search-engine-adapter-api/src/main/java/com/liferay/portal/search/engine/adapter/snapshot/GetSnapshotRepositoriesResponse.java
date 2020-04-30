/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.snapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class GetSnapshotRepositoriesResponse implements SnapshotResponse {

	public void addSnapshotRepositoryMetadata(
		SnapshotRepositoryDetails snapshotRepositoryDetails) {

		_snapshotRepositoryDetails.add(snapshotRepositoryDetails);
	}

	public List<SnapshotRepositoryDetails> getSnapshotRepositoryDetails() {
		return _snapshotRepositoryDetails;
	}

	private final List<SnapshotRepositoryDetails> _snapshotRepositoryDetails =
		new ArrayList<>();

}