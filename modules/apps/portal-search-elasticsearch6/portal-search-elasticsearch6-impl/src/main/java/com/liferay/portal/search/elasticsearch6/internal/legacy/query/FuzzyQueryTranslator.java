/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.legacy.query;

import com.liferay.portal.kernel.search.generic.FuzzyQuery;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Michael C. Han
 */
public interface FuzzyQueryTranslator {

	public QueryBuilder translate(FuzzyQuery fuzzyQuery);

}