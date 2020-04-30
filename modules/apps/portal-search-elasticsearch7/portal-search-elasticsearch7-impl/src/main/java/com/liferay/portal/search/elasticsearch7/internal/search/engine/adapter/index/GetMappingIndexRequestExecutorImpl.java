/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.index;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.index.GetMappingIndexRequest;
import com.liferay.portal.search.engine.adapter.index.GetMappingIndexResponse;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.compress.CompressedXContent;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Dylan Rebelak
 */
@Component(immediate = true, service = GetMappingIndexRequestExecutor.class)
public class GetMappingIndexRequestExecutorImpl
	implements GetMappingIndexRequestExecutor {

	@Override
	public GetMappingIndexResponse execute(
		GetMappingIndexRequest getMappingIndexRequest) {

		GetMappingsRequest getMappingsRequest = createGetMappingsRequest(
			getMappingIndexRequest);

		GetMappingsResponse getMappingsResponse = getGetMappingsResponse(
			getMappingsRequest, getMappingIndexRequest);

		ImmutableOpenMap<String, ImmutableOpenMap<String, MappingMetaData>>
			mappings = getMappingsResponse.mappings();

		Map<String, String> indexMappings = new HashMap<>();

		for (String indexName : getMappingIndexRequest.getIndexNames()) {
			ImmutableOpenMap<String, MappingMetaData> indexMapping =
				mappings.get(indexName);

			MappingMetaData mappingMetaData = indexMapping.get(
				getMappingIndexRequest.getMappingName());

			CompressedXContent mappingContent = mappingMetaData.source();

			indexMappings.put(indexName, mappingContent.toString());
		}

		return new GetMappingIndexResponse(indexMappings);
	}

	protected GetMappingsRequest createGetMappingsRequest(
		GetMappingIndexRequest getMappingIndexRequest) {

		GetMappingsRequest getMappingsRequest = new GetMappingsRequest();

		getMappingsRequest.indices(getMappingIndexRequest.getIndexNames());
		getMappingsRequest.types(getMappingIndexRequest.getMappingName());

		return getMappingsRequest;
	}

	protected GetMappingsResponse getGetMappingsResponse(
		GetMappingsRequest getMappingsRequest,
		GetMappingIndexRequest getMappingIndexRequest) {

		RestHighLevelClient restHighLevelClient =
			_elasticsearchClientResolver.getRestHighLevelClient(
				getMappingIndexRequest.getConnectionId(), true);

		IndicesClient indicesClient = restHighLevelClient.indices();

		try {
			return indicesClient.getMapping(
				getMappingsRequest, RequestOptions.DEFAULT);
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