/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eduardo García
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.portal.kernel.model.User",
	service = ModelPreFilterContributor.class
)
public class UserModelPreFilterContributor
	implements ModelPreFilterContributor {

	@Override
	public void contribute(
		BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
		SearchContext searchContext) {

		long[] segmentsEntryIds = (long[])searchContext.getAttribute(
			"segmentsEntryIds");

		if (ArrayUtil.isNotEmpty(segmentsEntryIds)) {
			TermsFilter segmentsEntryIdsTermsFilter = new TermsFilter(
				"segmentsEntryIds");

			segmentsEntryIdsTermsFilter.addValues(
				ArrayUtil.toStringArray(segmentsEntryIds));

			booleanFilter.add(
				segmentsEntryIdsTermsFilter, BooleanClauseOccur.MUST);
		}
	}

}