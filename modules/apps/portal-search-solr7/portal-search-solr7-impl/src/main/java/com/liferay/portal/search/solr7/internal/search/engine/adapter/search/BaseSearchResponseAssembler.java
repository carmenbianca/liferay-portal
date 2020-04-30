/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.search;

import com.liferay.portal.search.engine.adapter.search.BaseSearchRequest;
import com.liferay.portal.search.engine.adapter.search.BaseSearchResponse;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;

/**
 * @author Bryan Engler
 */
public interface BaseSearchResponseAssembler {

	public void assemble(
		BaseSearchResponse baseSearchResponse, SolrQuery solrQuery,
		QueryResponse queryResponse, BaseSearchRequest baseSearchRequest);

}