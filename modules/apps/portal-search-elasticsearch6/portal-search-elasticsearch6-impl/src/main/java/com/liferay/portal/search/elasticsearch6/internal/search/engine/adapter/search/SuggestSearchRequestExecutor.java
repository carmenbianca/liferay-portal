/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.search;

import com.liferay.portal.search.engine.adapter.search.SuggestSearchRequest;
import com.liferay.portal.search.engine.adapter.search.SuggestSearchResponse;

/**
 * @author Michael C. Han
 */
public interface SuggestSearchRequestExecutor {

	public SuggestSearchResponse execute(
		SuggestSearchRequest suggestSearchRequest);

}