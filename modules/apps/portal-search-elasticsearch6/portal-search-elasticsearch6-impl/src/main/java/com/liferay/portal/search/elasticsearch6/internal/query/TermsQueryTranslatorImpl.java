/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.query.TermsQuery;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = TermsQueryTranslator.class)
public class TermsQueryTranslatorImpl implements TermsQueryTranslator {

	@Override
	public QueryBuilder translate(TermsQuery termsQuery) {
		return QueryBuilders.termsQuery(
			termsQuery.getField(), termsQuery.getValues());
	}

}