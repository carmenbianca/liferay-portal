/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.ccr;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.ccr.UnfollowCCRRequest;
import com.liferay.portal.search.engine.adapter.ccr.UnfollowCCRResponse;

import java.io.IOException;

import org.elasticsearch.client.CcrClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.ccr.UnfollowRequest;
import org.elasticsearch.client.core.AcknowledgedResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(service = UnfollowCCRRequestExecutor.class)
public class UnfollowCCRRequestExecutorImpl
	implements UnfollowCCRRequestExecutor {

	@Override
	public UnfollowCCRResponse execute(UnfollowCCRRequest unfollowCCRRequest) {
		UnfollowRequest unfollowRequest = createUnfollowRequest(
			unfollowCCRRequest);

		AcknowledgedResponse acknowledgedResponse = getAcknowledgedResponse(
			unfollowRequest, unfollowCCRRequest);

		return new UnfollowCCRResponse(acknowledgedResponse.isAcknowledged());
	}

	protected UnfollowRequest createUnfollowRequest(
		UnfollowCCRRequest unfollowCCRRequest) {

		return new UnfollowRequest(unfollowCCRRequest.getIndexName());
	}

	protected AcknowledgedResponse getAcknowledgedResponse(
		UnfollowRequest unfollowRequest,
		UnfollowCCRRequest unfollowCCRRequest) {

		RestHighLevelClient restHighLevelClient =
			_elasticsearchClientResolver.getRestHighLevelClient(
				unfollowCCRRequest.getConnectionId(), true);

		CcrClient ccrClient = restHighLevelClient.ccr();

		try {
			return ccrClient.unfollow(unfollowRequest, RequestOptions.DEFAULT);
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