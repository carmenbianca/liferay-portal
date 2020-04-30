/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.index;

import com.carrotsearch.hppc.cursors.ObjectObjectCursor;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.index.GetIndexIndexRequest;
import com.liferay.portal.search.engine.adapter.index.GetIndexIndexResponse;

import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.compress.CompressedXContent;
import org.elasticsearch.common.settings.Settings;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(service = GetIndexIndexRequestExecutor.class)
public class GetIndexIndexRequestExecutorImpl
	implements GetIndexIndexRequestExecutor {

	@Override
	public GetIndexIndexResponse execute(
		GetIndexIndexRequest getIndexIndexRequest) {

		GetIndexRequest getIndexRequest = createGetIndexRequest(
			getIndexIndexRequest);

		GetIndexResponse getIndexResponse = getGetIndexResponse(
			getIndexRequest, getIndexIndexRequest);

		GetIndexIndexResponse getIndexIndexResponse =
			new GetIndexIndexResponse();

		getIndexIndexResponse.setIndexNames(getIndexResponse.getIndices());

		ImmutableOpenMap<String, ImmutableOpenMap<String, MappingMetaData>>
			indicesMappings = getIndexResponse.getMappings();

		getIndexIndexResponse.setMappings(convertMappings(indicesMappings));

		ImmutableOpenMap<String, Settings> indicesSettings =
			getIndexResponse.getSettings();

		getIndexIndexResponse.setSettings(convertSettings(indicesSettings));

		return getIndexIndexResponse;
	}

	protected Map<String, Map<String, String>> convertMappings(
		ImmutableOpenMap<String, ImmutableOpenMap<String, MappingMetaData>>
			indicesMappings) {

		Iterator
			<ObjectObjectCursor
				<String, ImmutableOpenMap<String, MappingMetaData>>> iterator =
					indicesMappings.iterator();

		Map<String, Map<String, String>> indexMappings = new HashMap<>();

		while (iterator.hasNext()) {
			ObjectObjectCursor
				<String, ImmutableOpenMap<String, MappingMetaData>>
					objectObjectCursor = iterator.next();

			ImmutableOpenMap<String, MappingMetaData> typeMappingsData =
				objectObjectCursor.value;

			Map<String, String> indiceTypeMappings = new HashMap<>();

			indexMappings.put(objectObjectCursor.key, indiceTypeMappings);

			Iterator<ObjectObjectCursor<String, MappingMetaData>>
				typeMappingsIterator = typeMappingsData.iterator();

			while (typeMappingsIterator.hasNext()) {
				ObjectObjectCursor<String, MappingMetaData>
					typeMappingsObjectObjectCursor =
						typeMappingsIterator.next();

				MappingMetaData mappingMetaData =
					typeMappingsObjectObjectCursor.value;

				CompressedXContent mappingContent = mappingMetaData.source();

				indiceTypeMappings.put(
					typeMappingsObjectObjectCursor.key,
					mappingContent.toString());
			}
		}

		return indexMappings;
	}

	protected Map<String, String> convertSettings(
		ImmutableOpenMap<String, Settings> indicesSettings) {

		Iterator<ObjectObjectCursor<String, Settings>> iterator =
			indicesSettings.iterator();

		Map<String, String> indicesSettingsMap = new HashMap<>();

		while (iterator.hasNext()) {
			ObjectObjectCursor<String, Settings> objectObjectCursor =
				iterator.next();

			Settings settings = objectObjectCursor.value;

			indicesSettingsMap.put(objectObjectCursor.key, settings.toString());
		}

		return indicesSettingsMap;
	}

	protected GetIndexRequest createGetIndexRequest(
		GetIndexIndexRequest getIndexIndexRequest) {

		GetIndexRequest getIndexRequest = new GetIndexRequest();

		getIndexRequest.indices(getIndexIndexRequest.getIndexNames());

		return getIndexRequest;
	}

	protected GetIndexResponse getGetIndexResponse(
		GetIndexRequest getIndexRequest,
		GetIndexIndexRequest getIndexIndexRequest) {

		RestHighLevelClient restHighLevelClient =
			_elasticsearchClientResolver.getRestHighLevelClient(
				getIndexIndexRequest.getConnectionId(), true);

		IndicesClient indicesClient = restHighLevelClient.indices();

		try {
			return indicesClient.get(getIndexRequest, RequestOptions.DEFAULT);
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