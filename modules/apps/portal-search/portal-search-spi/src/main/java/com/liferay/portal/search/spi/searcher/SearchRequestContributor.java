/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.searcher;

import com.liferay.portal.search.searcher.SearchRequest;

/**
 * @author André de Oliveira
 */
public interface SearchRequestContributor {

	public SearchRequest contribute(SearchRequest searchRequest);

}