/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.search;

import com.liferay.portal.kernel.search.suggest.SuggesterResult;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class SuggesterResults {

	public void addSuggesterResult(SuggesterResult suggesterResult) {
		_suggesterResults.put(suggesterResult.getName(), suggesterResult);
	}

	public Collection<String> getSuggesterNames() {
		return Collections.unmodifiableCollection(_suggesterResults.keySet());
	}

	public SuggesterResult getSuggesterResult(String name) {
		return _suggesterResults.get(name);
	}

	public Collection<SuggesterResult> getSuggesterResults() {
		return Collections.unmodifiableCollection(_suggesterResults.values());
	}

	private final Map<String, SuggesterResult> _suggesterResults =
		new HashMap<>();

}