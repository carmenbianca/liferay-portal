/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.snapshot;

/**
 * @author Michael C. Han
 */
public class CreateSnapshotResponse implements SnapshotResponse {

	public CreateSnapshotResponse(SnapshotDetails snapshotDetails) {
		_snapshotDetails = snapshotDetails;
	}

	public SnapshotDetails getSnapshotDetails() {
		return _snapshotDetails;
	}

	private final SnapshotDetails _snapshotDetails;

}