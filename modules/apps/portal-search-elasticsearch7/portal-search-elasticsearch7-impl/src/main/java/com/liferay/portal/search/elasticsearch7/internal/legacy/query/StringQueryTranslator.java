/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.legacy.query;

import com.liferay.portal.kernel.search.generic.StringQuery;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Michael C. Han
 */
public interface StringQueryTranslator {

	public QueryBuilder translate(StringQuery stringQuery);

}