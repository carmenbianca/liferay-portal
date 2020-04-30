/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.filter;

import com.liferay.portal.kernel.search.filter.TermFilter;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = TermFilterTranslator.class)
public class TermFilterTranslatorImpl implements TermFilterTranslator {

	@Override
	public QueryBuilder translate(TermFilter termFilter) {
		return QueryBuilders.termQuery(
			termFilter.getField(), termFilter.getValue());
	}

}