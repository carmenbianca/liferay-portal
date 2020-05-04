/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.document;

import com.liferay.portal.kernel.search.query.QueryTranslator;
import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.document.DeleteByQueryDocumentRequest;
import com.liferay.portal.search.engine.adapter.document.DeleteByQueryDocumentResponse;

import java.io.IOException;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Dylan Rebelak
 */
@Component(
	immediate = true, service = DeleteByQueryDocumentRequestExecutor.class
)
public class DeleteByQueryDocumentRequestExecutorImpl
	implements DeleteByQueryDocumentRequestExecutor {

	@Override
	public DeleteByQueryDocumentResponse execute(
		DeleteByQueryDocumentRequest deleteByQueryDocumentRequest) {

		DeleteByQueryRequest deleteByQueryRequest = createDeleteByQueryRequest(
			deleteByQueryDocumentRequest);

		BulkByScrollResponse bulkByScrollResponse = getBulkByScrollResponse(
			deleteByQueryRequest, deleteByQueryDocumentRequest);

		TimeValue timeValue = bulkByScrollResponse.getTook();

		return new DeleteByQueryDocumentResponse(
			bulkByScrollResponse.getDeleted(), timeValue.getMillis());
	}

	protected DeleteByQueryRequest createDeleteByQueryRequest(
		DeleteByQueryDocumentRequest deleteByQueryDocumentRequest) {

		DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();

		deleteByQueryRequest.indices(
			deleteByQueryDocumentRequest.getIndexNames());

		QueryBuilder queryBuilder = _queryTranslator.translate(
			deleteByQueryDocumentRequest.getQuery(), null);

		deleteByQueryRequest.setQuery(queryBuilder);

		deleteByQueryRequest.setRefresh(
			deleteByQueryDocumentRequest.isRefresh());

		return deleteByQueryRequest;
	}

	protected BulkByScrollResponse getBulkByScrollResponse(
		DeleteByQueryRequest deleteByQueryRequest,
		DeleteByQueryDocumentRequest deleteByQueryDocumentRequest) {

		RestHighLevelClient restHighLevelClient =
			_elasticsearchClientResolver.getRestHighLevelClient(
				deleteByQueryDocumentRequest.getConnectionId(), false);

		try {
			return restHighLevelClient.deleteByQuery(
				deleteByQueryRequest, RequestOptions.DEFAULT);
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

	@Reference(target = "(search.engine.impl=Elasticsearch)", unbind = "-")
	protected void setQueryTranslator(
		QueryTranslator<QueryBuilder> queryTranslator) {

		_queryTranslator = queryTranslator;
	}

	private ElasticsearchClientResolver _elasticsearchClientResolver;
	private QueryTranslator<QueryBuilder> _queryTranslator;

}