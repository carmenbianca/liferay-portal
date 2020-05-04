/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.response;

import com.liferay.portal.search.engine.adapter.search.SearchSearchRequest;
import com.liferay.portal.search.engine.adapter.search.SearchSearchResponse;

import org.elasticsearch.action.search.SearchResponse;

/**
 * @author Dylan Rebelak
 */
public interface SearchResponseTranslator {

	public void populate(
		SearchSearchResponse searchSearchResponse,
		SearchResponse searchResponse, SearchSearchRequest searchSearchRequest);

}