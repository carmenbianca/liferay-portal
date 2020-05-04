/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.ccr;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.ccr.FollowInfoCCRRequest;
import com.liferay.portal.search.engine.adapter.ccr.FollowInfoCCRResponse;
import com.liferay.portal.search.engine.adapter.ccr.FollowInfoStatus;

import java.io.IOException;

import java.util.List;

import org.elasticsearch.client.CcrClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.ccr.FollowInfoRequest;
import org.elasticsearch.client.ccr.FollowInfoResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(service = FollowInfoCCRRequestExecutor.class)
public class FollowInfoCCRRequestExecutorImpl
	implements FollowInfoCCRRequestExecutor {

	@Override
	public FollowInfoCCRResponse execute(
		FollowInfoCCRRequest followInfoCCRRequest) {

		FollowInfoRequest followInfoRequest = createFollowInfoRequest(
			followInfoCCRRequest);

		FollowInfoResponse followInfoResponse = getFollowInfoResponse(
			followInfoRequest, followInfoCCRRequest);

		List<FollowInfoResponse.FollowerInfo> followerInfos =
			followInfoResponse.getInfos();

		FollowInfoResponse.FollowerInfo followerInfo = followerInfos.get(0);

		FollowInfoResponse.Status status = followerInfo.getStatus();

		if (status == FollowInfoResponse.Status.ACTIVE) {
			return new FollowInfoCCRResponse(FollowInfoStatus.ACTIVE);
		}

		return new FollowInfoCCRResponse(FollowInfoStatus.PAUSED);
	}

	protected FollowInfoRequest createFollowInfoRequest(
		FollowInfoCCRRequest followInfoCCRRequest) {

		return new FollowInfoRequest(followInfoCCRRequest.getIndexName());
	}

	protected FollowInfoResponse getFollowInfoResponse(
		FollowInfoRequest followInfoRequest,
		FollowInfoCCRRequest followInfoCCRRequest) {

		RestHighLevelClient restHighLevelClient =
			_elasticsearchClientResolver.getRestHighLevelClient(
				followInfoCCRRequest.getConnectionId(), true);

		CcrClient ccrClient = restHighLevelClient.ccr();

		try {
			return ccrClient.getFollowInfo(
				followInfoRequest, RequestOptions.DEFAULT);
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