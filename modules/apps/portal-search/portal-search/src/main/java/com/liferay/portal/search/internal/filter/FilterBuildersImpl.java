/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.filter;

import com.liferay.portal.search.filter.DateRangeFilterBuilder;
import com.liferay.portal.search.filter.FilterBuilders;
import com.liferay.portal.search.filter.TermsSetFilterBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 */
@Component(immediate = true, service = FilterBuilders.class)
public class FilterBuildersImpl implements FilterBuilders {

	@Override
	public DateRangeFilterBuilder dateRangeFilterBuilder() {
		return new DateRangeFilterBuilderImpl();
	}

	@Override
	public TermsSetFilterBuilder termsSetFilterBuilder() {
		return new TermsSetFilterBuilderImpl();
	}

}