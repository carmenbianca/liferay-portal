/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.document;

import com.liferay.portal.search.engine.adapter.document.BulkableDocumentRequestTranslator;
import com.liferay.portal.search.engine.adapter.document.UpdateDocumentRequest;
import com.liferay.portal.search.engine.adapter.document.UpdateDocumentResponse;
import com.liferay.portal.search.solr7.internal.connection.SolrClientManager;

import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = UpdateDocumentRequestExecutor.class)
public class UpdateDocumentRequestExecutorImpl
	implements UpdateDocumentRequestExecutor {

	@Override
	public UpdateDocumentResponse execute(
		UpdateDocumentRequest updateDocumentRequest) {

		UpdateRequest request = _bulkableDocumentRequestTranslator.translate(
			updateDocumentRequest);

		try {
			UpdateResponse updateResponse = request.process(
				_solrClientManager.getSolrClient(),
				updateDocumentRequest.getIndexName());

			return new UpdateDocumentResponse(updateResponse.getStatus());
		}
		catch (Exception exception) {
			if (exception instanceof SolrException) {
				SolrException solrException = (SolrException)exception;

				throw solrException;
			}

			throw new RuntimeException(exception);
		}
	}

	@Reference(target = "(search.engine.impl=Solr)", unbind = "-")
	protected void setBulkableDocumentRequestTranslator(
		BulkableDocumentRequestTranslator bulkableDocumentRequestTranslator) {

		_bulkableDocumentRequestTranslator = bulkableDocumentRequestTranslator;
	}

	@Reference(unbind = "-")
	protected void setSolrClientManager(SolrClientManager solrClientManager) {
		_solrClientManager = solrClientManager;
	}

	private BulkableDocumentRequestTranslator
		_bulkableDocumentRequestTranslator;
	private SolrClientManager _solrClientManager;

}