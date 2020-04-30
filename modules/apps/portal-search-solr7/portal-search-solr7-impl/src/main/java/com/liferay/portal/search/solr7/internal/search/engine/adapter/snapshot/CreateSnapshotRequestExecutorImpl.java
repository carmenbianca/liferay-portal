/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.engine.adapter.snapshot.CreateSnapshotRequest;
import com.liferay.portal.search.engine.adapter.snapshot.CreateSnapshotResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = CreateSnapshotRequestExecutor.class)
public class CreateSnapshotRequestExecutorImpl
	implements CreateSnapshotRequestExecutor {

	@Override
	public CreateSnapshotResponse execute(
		CreateSnapshotRequest createSnapshotRequest) {

		throw new UnsupportedOperationException();
	}

}