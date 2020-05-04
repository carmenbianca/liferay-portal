/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vagner B.C
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.portal.kernel.model.Layout",
	service = ModelPreFilterContributor.class
)
public class LayoutModelPreFilterContributor
	implements ModelPreFilterContributor {

	@Override
	public void contribute(
		BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
		SearchContext searchContext) {

		String[] types = GetterUtil.getStringValues(
			searchContext.getAttribute(Field.TYPE),
			new String[] {LayoutConstants.TYPE_CONTENT});

		if (ArrayUtil.isNotEmpty(types)) {
			TermsFilter typeTermsFilter = new TermsFilter(Field.TYPE);

			typeTermsFilter.addValues(types);

			booleanFilter.add(typeTermsFilter, BooleanClauseOccur.MUST);
		}

		String privateLayout = (String)searchContext.getAttribute(
			"privateLayout");

		if (Validator.isNotNull(privateLayout)) {
			TermFilter privateLayoutTermFilter = new TermFilter(
				"privateLayout", privateLayout);

			booleanFilter.add(privateLayoutTermFilter, BooleanClauseOccur.MUST);
		}
	}

}