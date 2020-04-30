/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.search;

import com.liferay.portal.search.engine.adapter.search.BaseSearchRequest;
import com.liferay.portal.search.engine.adapter.search.BaseSearchResponse;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;

/**
 * @author Michael C. Han
 */
public interface CommonSearchResponseAssembler {

	public void assemble(
		SearchRequestBuilder searchRequestBuilder,
		SearchResponse searchResponse, BaseSearchRequest baseSearchRequest,
		BaseSearchResponse baseSearchResponse);

}