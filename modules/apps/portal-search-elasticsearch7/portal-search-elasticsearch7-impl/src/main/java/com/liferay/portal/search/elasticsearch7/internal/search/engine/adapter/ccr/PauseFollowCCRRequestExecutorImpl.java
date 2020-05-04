/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.ccr;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.ccr.PauseFollowCCRRequest;
import com.liferay.portal.search.engine.adapter.ccr.PauseFollowCCRResponse;

import java.io.IOException;

import org.elasticsearch.client.CcrClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.ccr.PauseFollowRequest;
import org.elasticsearch.client.core.AcknowledgedResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(service = PauseFollowCCRRequestExecutor.class)
public class PauseFollowCCRRequestExecutorImpl
	implements PauseFollowCCRRequestExecutor {

	@Override
	public PauseFollowCCRResponse execute(
		PauseFollowCCRRequest pauseFollowCCRRequest) {

		PauseFollowRequest pauseFollowRequest = createPauseFollowRequest(
			pauseFollowCCRRequest);

		AcknowledgedResponse acknowledgedResponse = getAcknowledgedResponse(
			pauseFollowRequest, pauseFollowCCRRequest);

		return new PauseFollowCCRResponse(
			acknowledgedResponse.isAcknowledged());
	}

	protected PauseFollowRequest createPauseFollowRequest(
		PauseFollowCCRRequest pauseFollowCCRRequest) {

		return new PauseFollowRequest(pauseFollowCCRRequest.getIndexName());
	}

	protected AcknowledgedResponse getAcknowledgedResponse(
		PauseFollowRequest pauseFollowRequest,
		PauseFollowCCRRequest pauseFollowCCRRequest) {

		RestHighLevelClient restHighLevelClient =
			_elasticsearchClientResolver.getRestHighLevelClient(
				pauseFollowCCRRequest.getConnectionId(), true);

		CcrClient ccrClient = restHighLevelClient.ccr();

		try {
			return ccrClient.pauseFollow(
				pauseFollowRequest, RequestOptions.DEFAULT);
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