/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.index;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.index.IndexInformation;
import com.liferay.portal.search.index.IndexNameBuilder;

import java.io.IOException;

import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adam Brandizzi
 */
@Component(immediate = true, service = IndexInformation.class)
public class ElasticsearchIndexInformation implements IndexInformation {

	@Override
	public String getCompanyIndexName(long companyId) {
		return indexNameBuilder.getIndexName(companyId);
	}

	@Override
	public String getFieldMappings(String indexName) {
		GetMappingsRequest getMappingsRequest = new GetMappingsRequest();

		getMappingsRequest.indices(indexName);

		GetMappingsResponse getMappingsResponse = getMappingsResponse(
			getMappingsRequest);

		return Strings.toString(getMappingsResponse, true, true);
	}

	@Override
	public String[] getIndexNames() {
		GetIndexRequest getIndexRequest = new GetIndexRequest();

		getIndexRequest.indices(StringPool.STAR);

		GetIndexResponse getIndexResponse = getIndexResponse(getIndexRequest);

		return getIndexResponse.getIndices();
	}

	protected GetIndexResponse getIndexResponse(
		GetIndexRequest getIndexRequest) {

		IndicesClient indicesClient = getIndicesClient();

		try {
			return indicesClient.get(getIndexRequest, RequestOptions.DEFAULT);
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	protected IndicesClient getIndicesClient() {
		RestHighLevelClient restHighLevelClient =
			elasticsearchClientResolver.getRestHighLevelClient(null, true);

		return restHighLevelClient.indices();
	}

	protected GetMappingsResponse getMappingsResponse(
		GetMappingsRequest getMappingsRequest) {

		IndicesClient indicesClient = getIndicesClient();

		try {
			return indicesClient.getMapping(
				getMappingsRequest, RequestOptions.DEFAULT);
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	@Reference
	protected ElasticsearchClientResolver elasticsearchClientResolver;

	@Reference
	protected IndexNameBuilder indexNameBuilder;

}