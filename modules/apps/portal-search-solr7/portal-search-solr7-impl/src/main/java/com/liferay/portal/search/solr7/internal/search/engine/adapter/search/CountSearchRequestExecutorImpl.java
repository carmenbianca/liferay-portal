/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.search;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.search.engine.adapter.search.CountSearchRequest;
import com.liferay.portal.search.engine.adapter.search.CountSearchResponse;
import com.liferay.portal.search.solr7.internal.connection.SolrClientManager;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = CountSearchRequestExecutor.class)
public class CountSearchRequestExecutorImpl
	implements CountSearchRequestExecutor {

	@Override
	public CountSearchResponse execute(CountSearchRequest countSearchRequest) {
		SolrQuery solrQuery = new SolrQuery();

		_baseSolrQueryAssembler.assemble(solrQuery, countSearchRequest);

		solrQuery.setRows(0);

		String requestString = solrQuery.toString();

		if (_log.isDebugEnabled()) {
			_log.debug("Search query " + requestString);
		}

		QueryResponse queryResponse = getQueryResponse(
			new QueryRequest(solrQuery), countSearchRequest.getIndexNames());

		CountSearchResponse countSearchResponse = new CountSearchResponse();

		_baseSearchResponseAssembler.assemble(
			countSearchResponse, solrQuery, queryResponse, countSearchRequest);

		if (_log.isDebugEnabled()) {
			_log.debug(
				StringBundler.concat(
					"The search engine processed ",
					countSearchResponse.getSearchRequestString(), " in ",
					countSearchResponse.getExecutionTime(), " ms"));
		}

		SolrDocumentList solrDocumentList = queryResponse.getResults();

		countSearchResponse.setCount(solrDocumentList.getNumFound());

		return countSearchResponse;
	}

	protected QueryResponse getQueryResponse(
		QueryRequest queryRequest, String[] indexNames) {

		try {
			queryRequest.setMethod(SolrRequest.METHOD.POST);

			return queryRequest.process(
				_solrClientManager.getSolrClient(), indexNames[0]);
		}
		catch (Exception exception) {
			if (exception instanceof SolrException) {
				SolrException solrException = (SolrException)exception;

				throw solrException;
			}

			throw new RuntimeException(exception);
		}
	}

	@Reference(unbind = "-")
	protected void setBaseSearchResponseAssembler(
		BaseSearchResponseAssembler baseSearchResponseAssembler) {

		_baseSearchResponseAssembler = baseSearchResponseAssembler;
	}

	@Reference(unbind = "-")
	protected void setBaseSolrQueryAssembler(
		BaseSolrQueryAssembler baseSolrQueryAssembler) {

		_baseSolrQueryAssembler = baseSolrQueryAssembler;
	}

	@Reference(unbind = "-")
	protected void setSolrClientManager(SolrClientManager solrClientManager) {
		_solrClientManager = solrClientManager;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CountSearchRequestExecutorImpl.class);

	private BaseSearchResponseAssembler _baseSearchResponseAssembler;
	private BaseSolrQueryAssembler _baseSolrQueryAssembler;
	private SolrClientManager _solrClientManager;

}