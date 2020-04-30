/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.snapshot;

/**
 * @author Michael C. Han
 */
public class DeleteSnapshotResponse implements SnapshotResponse {

	public DeleteSnapshotResponse(boolean acknowledged) {
		_acknowledged = acknowledged;
	}

	public boolean isAcknowledged() {
		return _acknowledged;
	}

	private final boolean _acknowledged;

}