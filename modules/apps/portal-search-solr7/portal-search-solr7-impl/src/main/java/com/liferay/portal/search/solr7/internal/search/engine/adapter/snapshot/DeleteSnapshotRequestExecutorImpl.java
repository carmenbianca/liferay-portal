/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.engine.adapter.snapshot.DeleteSnapshotRequest;
import com.liferay.portal.search.engine.adapter.snapshot.DeleteSnapshotResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = DeleteSnapshotRequestExecutor.class)
public class DeleteSnapshotRequestExecutorImpl
	implements DeleteSnapshotRequestExecutor {

	@Override
	public DeleteSnapshotResponse execute(
		DeleteSnapshotRequest deleteSnapshotRequest) {

		throw new UnsupportedOperationException();
	}

}