/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.cluster;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.cluster.StatsClusterRequest;
import com.liferay.portal.search.engine.adapter.cluster.StatsClusterResponse;

import java.io.IOException;

import org.elasticsearch.action.admin.cluster.stats.ClusterStatsAction;
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsRequestBuilder;
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsResponse;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Dylan Rebelak
 */
@Component(immediate = true, service = StatsClusterRequestExecutor.class)
public class StatsClusterRequestExecutorImpl
	implements StatsClusterRequestExecutor {

	@Override
	public StatsClusterResponse execute(
		StatsClusterRequest statsClusterRequest) {

		ClusterStatsRequestBuilder clusterStatsRequestBuilder =
			createClusterStatsRequestBuilder(statsClusterRequest);

		ClusterStatsResponse clusterStatsResponse =
			clusterStatsRequestBuilder.get();

		try {
			XContentBuilder xContentBuilder = XContentFactory.jsonBuilder();

			xContentBuilder.startObject();

			xContentBuilder = clusterStatsResponse.toXContent(
				xContentBuilder, ToXContent.EMPTY_PARAMS);

			xContentBuilder.endObject();

			ClusterHealthStatus clusterHealthStatus =
				clusterStatsResponse.getStatus();

			return new StatsClusterResponse(
				_clusterHealthStatusTranslator.translate(clusterHealthStatus),
				Strings.toString(xContentBuilder));
		}
		catch (IOException ioException) {
			throw new SystemException(ioException);
		}
	}

	protected ClusterStatsRequestBuilder createClusterStatsRequestBuilder(
		StatsClusterRequest statsClusterRequest) {

		return ClusterStatsAction.INSTANCE.newRequestBuilder(
			_elasticsearchClientResolver.getClient());
	}

	@Reference(unbind = "-")
	protected void setClusterHealthStatusTranslator(
		ClusterHealthStatusTranslator clusterHealthStatusTranslator) {

		_clusterHealthStatusTranslator = clusterHealthStatusTranslator;
	}

	@Reference(unbind = "-")
	protected void setElasticsearchClientResolver(
		ElasticsearchClientResolver elasticsearchClientResolver) {

		_elasticsearchClientResolver = elasticsearchClientResolver;
	}

	private ClusterHealthStatusTranslator _clusterHealthStatusTranslator;
	private ElasticsearchClientResolver _elasticsearchClientResolver;

}