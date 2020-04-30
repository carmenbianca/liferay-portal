/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.search;

import com.liferay.portal.search.engine.adapter.search.BaseSearchRequest;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.search.builder.SearchSourceBuilder;

/**
 * @author Michael C. Han
 */
public interface CommonSearchSourceBuilderAssembler {

	public void assemble(
		SearchSourceBuilder searchSourceBuilder,
		BaseSearchRequest baseSearchRequest, SearchRequest searchRequest);

}