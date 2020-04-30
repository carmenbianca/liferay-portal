/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.hits;

import com.liferay.portal.search.hits.SearchHitsBuilder;
import com.liferay.portal.search.hits.SearchHitsBuilderFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Wade Cao
 */
@Component(immediate = true, service = SearchHitsBuilderFactory.class)
public class SearchHitsBuilderFactoryImpl implements SearchHitsBuilderFactory {

	@Override
	public SearchHitsBuilder getSearchHitsBuilder() {
		return new SearchHitsImpl.Builder();
	}

}