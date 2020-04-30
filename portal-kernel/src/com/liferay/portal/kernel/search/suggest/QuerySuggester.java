/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.suggest;

import com.liferay.portal.kernel.messaging.proxy.MessagingProxy;
import com.liferay.portal.kernel.messaging.proxy.ProxyMode;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;

import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 */
@MessagingProxy(mode = ProxyMode.SYNC)
public interface QuerySuggester {

	public String spellCheckKeywords(SearchContext searchContext)
		throws SearchException;

	public Map<String, List<String>> spellCheckKeywords(
			SearchContext searchContext, int max)
		throws SearchException;

	public SuggesterResults suggest(
			SearchContext searchContext, Suggester suggester)
		throws SearchException;

	public String[] suggestKeywordQueries(SearchContext searchContext, int max)
		throws SearchException;

}