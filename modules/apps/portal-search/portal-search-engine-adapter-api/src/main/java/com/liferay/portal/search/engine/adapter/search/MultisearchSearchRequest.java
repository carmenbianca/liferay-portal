/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.search;

import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Dylan Rebelak
 */
public class MultisearchSearchRequest
	extends CrossClusterRequest
	implements SearchRequest<MultisearchSearchResponse> {

	@Override
	public MultisearchSearchResponse accept(
		SearchRequestExecutor searchRequestExecutor) {

		return searchRequestExecutor.executeSearchRequest(this);
	}

	public void addSearchSearchRequest(
		SearchSearchRequest searchSearchRequest) {

		_searchSearchRequests.add(searchSearchRequest);
	}

	public void addSearchSearchRequests(
		Collection<SearchSearchRequest> searchSearchRequests) {

		_searchSearchRequests.addAll(searchSearchRequests);
	}

	public List<SearchSearchRequest> getSearchSearchRequests() {
		return _searchSearchRequests;
	}

	private final List<SearchSearchRequest> _searchSearchRequests =
		new ArrayList<>();

}