/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query;

import com.liferay.portal.search.query.WrapperQuery;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Adam Brandizzi
 */
public interface WrapperQueryTranslator {

	public QueryBuilder translate(WrapperQuery wrapperQuery);

}