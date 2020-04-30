/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.spi.model.query.contributor;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.spi.model.query.contributor.QueryConfigContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.QueryConfigContributorHelper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = QueryConfigContributor.class)
public class DefaultHighlightFieldNamesQueryConfigContributor
	implements QueryConfigContributor {

	@Override
	public void contributeQueryConfigurations(
		SearchContext searchContext,
		QueryConfigContributorHelper queryConfigContributorHelper) {

		QueryConfig queryConfig = searchContext.getQueryConfig();

		queryConfig.addHighlightFieldNames(Field.ASSET_CATEGORY_TITLES);

		if (queryConfig.isHighlightEnabled()) {
			queryConfig.addHighlightFieldNames(
				Field.CONTENT, Field.DESCRIPTION, Field.TITLE);
		}
	}

}