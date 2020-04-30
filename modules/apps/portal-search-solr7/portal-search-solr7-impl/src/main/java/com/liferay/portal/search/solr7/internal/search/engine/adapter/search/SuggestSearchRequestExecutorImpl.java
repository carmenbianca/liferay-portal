/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.search;

import com.liferay.portal.search.engine.adapter.search.SuggestSearchRequest;
import com.liferay.portal.search.engine.adapter.search.SuggestSearchResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = SuggestSearchRequestExecutor.class)
public class SuggestSearchRequestExecutorImpl
	implements SuggestSearchRequestExecutor {

	@Override
	public SuggestSearchResponse execute(
		SuggestSearchRequest suggestSearchRequest) {

		throw new UnsupportedOperationException();
	}

}