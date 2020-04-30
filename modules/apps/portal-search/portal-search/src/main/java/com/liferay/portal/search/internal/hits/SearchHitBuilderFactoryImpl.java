/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.hits;

import com.liferay.portal.search.hits.SearchHitBuilder;
import com.liferay.portal.search.hits.SearchHitBuilderFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Wade Cao
 */
@Component(service = SearchHitBuilderFactory.class)
public class SearchHitBuilderFactoryImpl implements SearchHitBuilderFactory {

	@Override
	public SearchHitBuilder getSearchHitBuilder() {
		return new SearchHitImpl.Builder();
	}

}