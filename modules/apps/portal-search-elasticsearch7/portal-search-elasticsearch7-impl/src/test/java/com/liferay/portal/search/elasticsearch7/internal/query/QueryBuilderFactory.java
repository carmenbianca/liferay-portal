/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author André de Oliveira
 */
public interface QueryBuilderFactory {

	public QueryBuilder create(String name, String text);

}