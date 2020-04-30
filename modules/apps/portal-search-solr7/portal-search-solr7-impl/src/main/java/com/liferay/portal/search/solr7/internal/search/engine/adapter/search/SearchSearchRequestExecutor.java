/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.search;

import com.liferay.portal.search.engine.adapter.search.SearchSearchRequest;
import com.liferay.portal.search.engine.adapter.search.SearchSearchResponse;

/**
 * @author Bryan Engler
 */
public interface SearchSearchRequestExecutor {

	public SearchSearchResponse execute(
		SearchSearchRequest searchSearchRequest);

}