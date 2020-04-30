/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.QueryFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Inácio Nery
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.portal.workflow.kaleo.model.KaleoAction",
	service = ModelPreFilterContributor.class
)
public class KaleoActionModelPreFilterContributor
	implements ModelPreFilterContributor {

	@Override
	public void contribute(
		BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
		SearchContext searchContext) {

		String executionType = GetterUtil.getString(
			searchContext.getAttribute("executionType"));

		if (Validator.isNotNull(executionType)) {
			BooleanQuery booleanQuery = new BooleanQueryImpl();

			booleanQuery.addRequiredTerm("executionType", executionType);

			booleanFilter.add(new QueryFilter(booleanQuery));
		}

		long kaleoClassPK = GetterUtil.getLong(
			searchContext.getAttribute("kaleoClassPK"));

		if (kaleoClassPK > 0) {
			booleanFilter.addRequiredTerm("kaleoClassPK", kaleoClassPK);
		}
	}

}