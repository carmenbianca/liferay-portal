/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.query;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.query.QueryVisitor;

import org.apache.lucene.search.Query;

/**
 * @author André de Oliveira
 * @author Miguel Angelo Caldas Gallindo
 */
public interface BooleanQueryTranslator {

	public Query translate(
		BooleanQuery booleanQuery, QueryVisitor<Query> queryVisitor);

}