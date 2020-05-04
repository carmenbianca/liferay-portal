/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.filter;

import com.liferay.portal.kernel.search.filter.ExistsFilter;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = ExistsFilterTranslator.class)
public class ExistsFilterTranslatorImpl implements ExistsFilterTranslator {

	@Override
	public QueryBuilder translate(ExistsFilter existsFilter) {
		return QueryBuilders.existsQuery(existsFilter.getField());
	}

}