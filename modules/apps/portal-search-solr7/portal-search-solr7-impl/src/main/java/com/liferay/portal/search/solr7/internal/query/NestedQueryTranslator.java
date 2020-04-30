/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.query;

import com.liferay.portal.kernel.search.generic.NestedQuery;
import com.liferay.portal.kernel.search.query.QueryVisitor;

import org.apache.lucene.search.Query;

/**
 * @author Michael C. Han
 */
public interface NestedQueryTranslator {

	public Query translate(
		NestedQuery nestedQuery, QueryVisitor<Query> queryVisitor);

}