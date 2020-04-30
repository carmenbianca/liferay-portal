/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.filter;

import com.liferay.portal.kernel.search.filter.MissingFilter;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.ExistsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = MissingFilterTranslator.class)
public class MissingFilterTranslatorImpl implements MissingFilterTranslator {

	@Override
	public QueryBuilder translate(MissingFilter missingFilter) {
		BoolQueryBuilder missingQueryBuilder = new BoolQueryBuilder().mustNot(
			new ExistsQueryBuilder(missingFilter.getField()));

		if (missingFilter.isExists() != null) {
			missingFilter.setExists(missingFilter.isExists());
		}

		if (missingFilter.isNullValue() != null) {
			missingFilter.setNullValue(missingFilter.isNullValue());
		}

		return missingQueryBuilder;
	}

}