/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.document;

import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.elasticsearch6.internal.document.ElasticsearchDocumentFactory;
import com.liferay.portal.search.elasticsearch6.internal.legacy.query.ElasticsearchQueryTranslatorFixture;
import com.liferay.portal.search.engine.adapter.document.BulkableDocumentRequestTranslator;
import com.liferay.portal.search.engine.adapter.document.DocumentRequestExecutor;

/**
 * @author Dylan Rebelak
 */
public class DocumentRequestExecutorFixture {

	public DocumentRequestExecutor getDocumentRequestExecutor() {
		return _documentRequestExecutor;
	}

	public void setUp() {
		_documentRequestExecutor = createDocumentRequestExecutor(
			_elasticsearchClientResolver, _elasticsearchDocumentFactory);
	}

	protected static BulkableDocumentRequestTranslator
		createBulkableDocumentRequestTranslator(
			ElasticsearchClientResolver elasticsearchClientResolver,
			ElasticsearchDocumentFactory elasticsearchDocumentFactory) {

		return new ElasticsearchBulkableDocumentRequestTranslator() {
			{
				setElasticsearchClientResolver(elasticsearchClientResolver);
				setElasticsearchDocumentFactory(elasticsearchDocumentFactory);
			}
		};
	}

	protected static BulkDocumentRequestExecutor
		createBulkDocumentRequestExecutor(
			ElasticsearchClientResolver elasticsearchClientResolver,
			BulkableDocumentRequestTranslator
				bulkableDocumentRequestTranslator) {

		return new BulkDocumentRequestExecutorImpl() {
			{
				setBulkableDocumentRequestTranslator(
					bulkableDocumentRequestTranslator);
				setElasticsearchClientResolver(elasticsearchClientResolver);
			}
		};
	}

	protected static DeleteByQueryDocumentRequestExecutor
		createDeleteByQueryDocumentRequestExecutor(
			ElasticsearchClientResolver elasticsearchClientResolver) {

		return new DeleteByQueryDocumentRequestExecutorImpl() {
			{
				setElasticsearchClientResolver(elasticsearchClientResolver);

				ElasticsearchQueryTranslatorFixture
					elasticsearchQueryTranslatorFixture =
						new ElasticsearchQueryTranslatorFixture();

				setQueryTranslator(
					elasticsearchQueryTranslatorFixture.
						getElasticsearchQueryTranslator());
			}
		};
	}

	protected static DeleteDocumentRequestExecutor
		createDeleteDocumentRequestExecutor(
			BulkableDocumentRequestTranslator
				bulkableDocumentRequestTranslator) {

		return new DeleteDocumentRequestExecutorImpl() {
			{
				setBulkableDocumentRequestTranslator(
					bulkableDocumentRequestTranslator);
			}
		};
	}

	protected static DocumentRequestExecutor createDocumentRequestExecutor(
		ElasticsearchClientResolver elasticsearchClientResolver,
		ElasticsearchDocumentFactory elasticsearchDocumentFactory) {

		BulkableDocumentRequestTranslator bulkableDocumentRequestTranslator =
			createBulkableDocumentRequestTranslator(
				elasticsearchClientResolver, elasticsearchDocumentFactory);

		return new ElasticsearchDocumentRequestExecutor() {
			{
				setBulkDocumentRequestExecutor(
					createBulkDocumentRequestExecutor(
						elasticsearchClientResolver,
						bulkableDocumentRequestTranslator));
				setDeleteByQueryDocumentRequestExecutor(
					createDeleteByQueryDocumentRequestExecutor(
						elasticsearchClientResolver));
				setDeleteDocumentRequestExecutor(
					createDeleteDocumentRequestExecutor(
						bulkableDocumentRequestTranslator));
				setIndexDocumentRequestExecutor(
					createIndexDocumentRequestExecutor(
						bulkableDocumentRequestTranslator));
				setUpdateByQueryDocumentRequestExecutor(
					createUpdateByQueryDocumentRequestExecutor(
						elasticsearchClientResolver));
				setUpdateDocumentRequestExecutor(
					createUpdateDocumentRequestExecutor(
						bulkableDocumentRequestTranslator));
			}
		};
	}

	protected static IndexDocumentRequestExecutor
		createIndexDocumentRequestExecutor(
			BulkableDocumentRequestTranslator
				bulkableDocumentRequestTranslator) {

		return new IndexDocumentRequestExecutorImpl() {
			{
				setBulkableDocumentRequestTranslator(
					bulkableDocumentRequestTranslator);
			}
		};
	}

	protected static UpdateByQueryDocumentRequestExecutor
		createUpdateByQueryDocumentRequestExecutor(
			ElasticsearchClientResolver elasticsearchClientResolver) {

		return new UpdateByQueryDocumentRequestExecutorImpl() {
			{
				setElasticsearchClientResolver(elasticsearchClientResolver);

				ElasticsearchQueryTranslatorFixture
					elasticsearchQueryTranslatorFixture =
						new ElasticsearchQueryTranslatorFixture();

				setQueryTranslator(
					elasticsearchQueryTranslatorFixture.
						getElasticsearchQueryTranslator());
			}
		};
	}

	protected static UpdateDocumentRequestExecutor
		createUpdateDocumentRequestExecutor(
			BulkableDocumentRequestTranslator
				bulkableDocumentRequestTranslator) {

		return new UpdateDocumentRequestExecutorImpl() {
			{
				setBulkableDocumentRequestTranslator(
					bulkableDocumentRequestTranslator);
			}
		};
	}

	protected void setElasticsearchClientResolver(
		ElasticsearchClientResolver elasticsearchClientResolver) {

		_elasticsearchClientResolver = elasticsearchClientResolver;
	}

	protected void setElasticsearchDocumentFactory(
		ElasticsearchDocumentFactory elasticsearchDocumentFactory) {

		_elasticsearchDocumentFactory = elasticsearchDocumentFactory;
	}

	private DocumentRequestExecutor _documentRequestExecutor;
	private ElasticsearchClientResolver _elasticsearchClientResolver;
	private ElasticsearchDocumentFactory _elasticsearchDocumentFactory;

}