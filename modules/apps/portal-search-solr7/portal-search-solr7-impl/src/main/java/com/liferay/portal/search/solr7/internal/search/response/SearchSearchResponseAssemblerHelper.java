/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.response;

import com.liferay.portal.search.engine.adapter.search.SearchSearchRequest;
import com.liferay.portal.search.engine.adapter.search.SearchSearchResponse;

import org.apache.solr.client.solrj.response.QueryResponse;

/**
 * @author Bryan Engler
 */
public interface SearchSearchResponseAssemblerHelper {

	public void populate(
		SearchSearchResponse searchSearchResponse, QueryResponse queryResponse,
		SearchSearchRequest searchSearchRequest);

}