/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.search;

import com.liferay.portal.kernel.search.suggest.Suggester;
import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class SuggestSearchRequest
	extends CrossClusterRequest
	implements SearchRequest<SuggestSearchResponse> {

	public SuggestSearchRequest(String... indexNames) {
		_indexNames = indexNames;
	}

	@Override
	public SuggestSearchResponse accept(
		SearchRequestExecutor searchRequestExecutor) {

		return searchRequestExecutor.executeSearchRequest(this);
	}

	public void addSuggester(Suggester suggester) {
		_suggesterMap.put(suggester.getName(), suggester);
	}

	public String getGlobalText() {
		return _globalText;
	}

	public String[] getIndexNames() {
		return _indexNames;
	}

	public Suggester getSuggester(String name) {
		return _suggesterMap.get(name);
	}

	public Map<String, Suggester> getSuggesterMap() {
		return _suggesterMap;
	}

	public void setGlobalText(String globalText) {
		_globalText = globalText;
	}

	private String _globalText;
	private final String[] _indexNames;
	private Map<String, Suggester> _suggesterMap = new HashMap<>();

}