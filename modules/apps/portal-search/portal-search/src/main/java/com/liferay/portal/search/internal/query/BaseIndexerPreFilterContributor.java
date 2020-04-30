/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query;

import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.PreFilterContributor;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.search.internal.indexer.PreFilterContributorHelper;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author André de Oliveira
 */
@Component(immediate = true, service = PreFilterContributor.class)
public class BaseIndexerPreFilterContributor implements PreFilterContributor {

	@Override
	public void contribute(
		BooleanFilter booleanFilter,
		Map<String, Indexer<?>> entryClassNameIndexerMap,
		SearchContext searchContext) {

		preFilterContributorHelper.contribute(
			booleanFilter, entryClassNameIndexerMap, searchContext);
	}

	@Reference
	protected PreFilterContributorHelper preFilterContributorHelper;

}