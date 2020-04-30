/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.query.PrefixQuery;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Michael C. Han
 */
public interface PrefixQueryTranslator {

	public QueryBuilder translate(PrefixQuery prefixQuery);

}