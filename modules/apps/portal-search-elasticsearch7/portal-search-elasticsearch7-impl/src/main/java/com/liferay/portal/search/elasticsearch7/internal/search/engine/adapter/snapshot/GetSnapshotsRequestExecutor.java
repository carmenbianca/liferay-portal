/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.engine.adapter.snapshot.GetSnapshotsRequest;
import com.liferay.portal.search.engine.adapter.snapshot.GetSnapshotsResponse;

/**
 * @author Michael C. Han
 */
public interface GetSnapshotsRequestExecutor {

	public GetSnapshotsResponse execute(
		GetSnapshotsRequest getSnapshotsRequest);

}