/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.ccr;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.ccr.PutFollowCCRRequest;
import com.liferay.portal.search.engine.adapter.ccr.PutFollowCCRResponse;

import java.io.IOException;

import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.client.CcrClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.ccr.PutFollowRequest;
import org.elasticsearch.client.ccr.PutFollowResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(service = PutFollowCCRRequestExecutor.class)
public class PutFollowCCRRequestExecutorImpl
	implements PutFollowCCRRequestExecutor {

	@Override
	public PutFollowCCRResponse execute(
		PutFollowCCRRequest putFollowCCRRequest) {

		PutFollowRequest putFollowRequest = createPutFollowRequest(
			putFollowCCRRequest);

		PutFollowResponse putFollowResponse = getPutFollowResponse(
			putFollowRequest, putFollowCCRRequest);

		return new PutFollowCCRResponse(
			putFollowResponse.isFollowIndexCreated(),
			putFollowResponse.isIndexFollowingStarted());
	}

	protected PutFollowRequest createPutFollowRequest(
		PutFollowCCRRequest putFollowCCRRequest) {

		if (putFollowCCRRequest.getWaitForActiveShards() != 0) {
			return new PutFollowRequest(
				putFollowCCRRequest.getRemoteClusterAlias(),
				putFollowCCRRequest.getLeaderIndexName(),
				putFollowCCRRequest.getFollowerIndexName(),
				ActiveShardCount.from(
					putFollowCCRRequest.getWaitForActiveShards()));
		}

		return new PutFollowRequest(
			putFollowCCRRequest.getRemoteClusterAlias(),
			putFollowCCRRequest.getLeaderIndexName(),
			putFollowCCRRequest.getFollowerIndexName());
	}

	protected PutFollowResponse getPutFollowResponse(
		PutFollowRequest putFollowRequest,
		PutFollowCCRRequest putFollowCCRRequest) {

		RestHighLevelClient restHighLevelClient =
			_elasticsearchClientResolver.getRestHighLevelClient(
				putFollowCCRRequest.getConnectionId(), true);

		CcrClient ccrClient = restHighLevelClient.ccr();

		try {
			return ccrClient.putFollow(
				putFollowRequest, RequestOptions.DEFAULT);
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	@Reference(unbind = "-")
	protected void setElasticsearchClientResolver(
		ElasticsearchClientResolver elasticsearchClientResolver) {

		_elasticsearchClientResolver = elasticsearchClientResolver;
	}

	private ElasticsearchClientResolver _elasticsearchClientResolver;

}