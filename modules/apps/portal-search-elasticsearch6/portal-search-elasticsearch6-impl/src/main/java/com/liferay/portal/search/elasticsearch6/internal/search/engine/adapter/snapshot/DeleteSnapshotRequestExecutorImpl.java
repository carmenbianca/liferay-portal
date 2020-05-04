/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.snapshot.DeleteSnapshotRequest;
import com.liferay.portal.search.engine.adapter.snapshot.DeleteSnapshotResponse;

import org.elasticsearch.action.admin.cluster.snapshots.delete.DeleteSnapshotAction;
import org.elasticsearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequestBuilder;
import org.elasticsearch.action.support.master.AcknowledgedResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(service = DeleteSnapshotRequestExecutor.class)
public class DeleteSnapshotRequestExecutorImpl
	implements DeleteSnapshotRequestExecutor {

	@Override
	public DeleteSnapshotResponse execute(
		DeleteSnapshotRequest deleteSnapshotRequest) {

		DeleteSnapshotRequestBuilder deleteSnapshotRequestBuilder =
			createDeleteSnapshotRequestBuilder(deleteSnapshotRequest);

		AcknowledgedResponse acknowledgedResponse =
			deleteSnapshotRequestBuilder.get();

		return new DeleteSnapshotResponse(
			acknowledgedResponse.isAcknowledged());
	}

	protected DeleteSnapshotRequestBuilder createDeleteSnapshotRequestBuilder(
		DeleteSnapshotRequest deleteSnapshotRequest) {

		DeleteSnapshotRequestBuilder deleteSnapshotRequestBuilder =
			DeleteSnapshotAction.INSTANCE.newRequestBuilder(
				_elasticsearchClientResolver.getClient());

		deleteSnapshotRequestBuilder.setRepository(
			deleteSnapshotRequest.getRepositoryName());
		deleteSnapshotRequestBuilder.setSnapshot(
			deleteSnapshotRequest.getSnapshotName());

		return deleteSnapshotRequestBuilder;
	}

	@Reference(unbind = "-")
	protected void setElasticsearchClientResolver(
		ElasticsearchClientResolver elasticsearchClientResolver) {

		_elasticsearchClientResolver = elasticsearchClientResolver;
	}

	private ElasticsearchClientResolver _elasticsearchClientResolver;

}