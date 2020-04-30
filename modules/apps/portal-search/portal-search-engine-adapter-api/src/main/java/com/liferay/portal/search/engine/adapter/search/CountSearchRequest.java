/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.search;

/**
 * @author Dylan Rebelak
 */
public class CountSearchRequest
	extends BaseSearchRequest implements SearchRequest<CountSearchResponse> {

	@Override
	public CountSearchResponse accept(
		SearchRequestExecutor searchRequestExecutor) {

		return searchRequestExecutor.executeSearchRequest(this);
	}

}