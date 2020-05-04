/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.messaging.proxy.MessagingProxy;
import com.liferay.portal.kernel.messaging.proxy.ProxyMode;
import com.liferay.portal.kernel.search.suggest.QuerySuggester;

/**
 * @author Bruno Farache
 * @author Raymond Augé
 */
@MessagingProxy(mode = ProxyMode.SYNC)
public interface IndexSearcher extends QuerySuggester {

	public String getQueryString(SearchContext searchContext, Query query)
		throws ParseException;

	public Hits search(SearchContext searchContext, Query query)
		throws SearchException;

	public long searchCount(SearchContext searchContext, Query query)
		throws SearchException;

}