/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.document;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.search.query.QueryTranslator;
import com.liferay.portal.search.engine.adapter.document.DeleteByQueryDocumentRequest;
import com.liferay.portal.search.engine.adapter.document.DeleteByQueryDocumentResponse;
import com.liferay.portal.search.solr7.configuration.SolrConfiguration;
import com.liferay.portal.search.solr7.internal.connection.SolrClientManager;

import java.util.Map;

import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(
	configurationPid = "com.liferay.portal.search.solr7.configuration.SolrConfiguration",
	immediate = true, service = DeleteByQueryDocumentRequestExecutor.class
)
public class DeleteByQueryDocumentRequestExecutorImpl
	implements DeleteByQueryDocumentRequestExecutor {

	@Override
	public DeleteByQueryDocumentResponse execute(
		DeleteByQueryDocumentRequest deleteByQueryDocumentRequest) {

		UpdateRequest updateRequest = new UpdateRequest();

		String queryString = _queryTranslator.translate(
			deleteByQueryDocumentRequest.getQuery(), null);

		updateRequest.deleteByQuery(queryString);

		if (deleteByQueryDocumentRequest.isRefresh()) {
			updateRequest.setAction(UpdateRequest.ACTION.COMMIT, true, true);
		}

		try {
			UpdateResponse updateResponse = updateRequest.process(
				_solrClientManager.getSolrClient(), _defaultCollection);

			return new DeleteByQueryDocumentResponse(
				updateResponse.getStatus(), updateResponse.getElapsedTime());
		}
		catch (Exception exception) {
			if (exception instanceof SolrException) {
				SolrException solrException = (SolrException)exception;

				throw solrException;
			}

			throw new RuntimeException(exception);
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_solrConfiguration = ConfigurableUtil.createConfigurable(
			SolrConfiguration.class, properties);

		_defaultCollection = _solrConfiguration.defaultCollection();
	}

	@Reference(target = "(search.engine.impl=Solr)", unbind = "-")
	protected void setQueryTranslator(QueryTranslator<String> queryTranslator) {
		_queryTranslator = queryTranslator;
	}

	@Reference(unbind = "-")
	protected void setSolrClientManager(SolrClientManager solrClientManager) {
		_solrClientManager = solrClientManager;
	}

	private String _defaultCollection;
	private QueryTranslator<String> _queryTranslator;
	private SolrClientManager _solrClientManager;
	private volatile SolrConfiguration _solrConfiguration;

}