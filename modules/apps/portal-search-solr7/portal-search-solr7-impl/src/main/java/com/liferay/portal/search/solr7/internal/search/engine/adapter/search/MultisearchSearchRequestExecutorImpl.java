/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.search;

import com.liferay.portal.search.engine.adapter.search.MultisearchSearchRequest;
import com.liferay.portal.search.engine.adapter.search.MultisearchSearchResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = MultisearchSearchRequestExecutor.class)
public class MultisearchSearchRequestExecutorImpl
	implements MultisearchSearchRequestExecutor {

	@Override
	public MultisearchSearchResponse execute(
		MultisearchSearchRequest multisearchSearchRequest) {

		throw new UnsupportedOperationException();
	}

}