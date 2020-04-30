/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.filter;

import com.liferay.portal.search.filter.TermsSetFilter;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Marco Leo
 */
public interface TermsSetFilterTranslator {

	public QueryBuilder translate(TermsSetFilter termsSetFilter);

}