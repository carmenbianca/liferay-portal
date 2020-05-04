/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.engine.adapter.snapshot.RestoreSnapshotRequest;
import com.liferay.portal.search.engine.adapter.snapshot.RestoreSnapshotResponse;

/**
 * @author Bryan Engler
 */
public interface RestoreSnapshotRequestExecutor {

	public RestoreSnapshotResponse execute(
		RestoreSnapshotRequest restoreSnapshotRequest);

}