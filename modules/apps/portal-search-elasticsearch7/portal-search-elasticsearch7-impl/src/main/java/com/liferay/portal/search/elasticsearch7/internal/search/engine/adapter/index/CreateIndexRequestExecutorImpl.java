/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.index;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.elasticsearch7.internal.util.ClassLoaderUtil;
import com.liferay.portal.search.elasticsearch7.internal.util.LogUtil;
import com.liferay.portal.search.engine.adapter.index.CreateIndexRequest;
import com.liferay.portal.search.engine.adapter.index.CreateIndexResponse;

import java.io.IOException;

import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(service = CreateIndexRequestExecutor.class)
public class CreateIndexRequestExecutorImpl
	implements CreateIndexRequestExecutor {

	@Override
	public CreateIndexResponse execute(CreateIndexRequest createIndexRequest) {
		org.elasticsearch.action.admin.indices.create.CreateIndexRequest
			elasticsearchCreateIndexRequest = createCreateIndexRequest(
				createIndexRequest);

		org.elasticsearch.action.admin.indices.create.CreateIndexResponse
			elasticsearchCreateIndexResponse = getCreateIndexResponse(
				elasticsearchCreateIndexRequest, createIndexRequest);

		LogUtil.logActionResponse(_log, elasticsearchCreateIndexResponse);

		return new CreateIndexResponse(
			elasticsearchCreateIndexResponse.isAcknowledged(),
			elasticsearchCreateIndexResponse.index());
	}

	protected org.elasticsearch.action.admin.indices.create.CreateIndexRequest
		createCreateIndexRequest(CreateIndexRequest createIndexRequest) {

		org.elasticsearch.action.admin.indices.create.CreateIndexRequest
			elasticsearchCreateIndexRequest =
				new org.elasticsearch.action.admin.indices.create.
					CreateIndexRequest(createIndexRequest.getIndexName());

		Class<? extends CreateIndexRequestExecutorImpl> clazz = getClass();

		if (createIndexRequest.getSource() != null) {
			ClassLoaderUtil.getWithContextClassLoader(
				() -> elasticsearchCreateIndexRequest.source(
					createIndexRequest.getSource(), XContentType.JSON),
				clazz);
		}

		return elasticsearchCreateIndexRequest;
	}

	protected org.elasticsearch.action.admin.indices.create.CreateIndexResponse
		getCreateIndexResponse(
			org.elasticsearch.action.admin.indices.create.CreateIndexRequest
				elasticsearchCreateIndexRequest,
			CreateIndexRequest createIndexRequest) {

		RestHighLevelClient restHighLevelClient =
			_elasticsearchClientResolver.getRestHighLevelClient(
				createIndexRequest.getConnectionId(), false);

		IndicesClient indicesClient = restHighLevelClient.indices();

		try {
			return indicesClient.create(
				elasticsearchCreateIndexRequest, RequestOptions.DEFAULT);
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

	private static final Log _log = LogFactoryUtil.getLog(
		CreateIndexRequestExecutorImpl.class);

	private ElasticsearchClientResolver _elasticsearchClientResolver;

}