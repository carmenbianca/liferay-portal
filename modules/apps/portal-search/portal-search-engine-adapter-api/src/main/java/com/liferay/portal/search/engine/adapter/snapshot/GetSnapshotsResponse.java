/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.snapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class GetSnapshotsResponse implements SnapshotResponse {

	public void addSnapshotInfo(SnapshotDetails snapshotDetails) {
		_snapshotDetails.add(snapshotDetails);
	}

	public List<SnapshotDetails> getSnapshotDetails() {
		return _snapshotDetails;
	}

	private final List<SnapshotDetails> _snapshotDetails = new ArrayList<>();

}