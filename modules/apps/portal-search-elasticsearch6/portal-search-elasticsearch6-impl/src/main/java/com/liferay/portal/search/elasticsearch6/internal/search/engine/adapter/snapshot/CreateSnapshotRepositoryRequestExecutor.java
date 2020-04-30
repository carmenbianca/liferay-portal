/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.engine.adapter.snapshot.CreateSnapshotRepositoryRequest;
import com.liferay.portal.search.engine.adapter.snapshot.CreateSnapshotRepositoryResponse;

/**
 * @author Michael C. Han
 */
public interface CreateSnapshotRepositoryRequestExecutor {

	public CreateSnapshotRepositoryResponse execute(
		CreateSnapshotRepositoryRequest createSnapshotRepositoryRequest);

}