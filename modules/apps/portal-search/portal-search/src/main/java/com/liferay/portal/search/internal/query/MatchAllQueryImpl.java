/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query;

import com.liferay.portal.search.query.MatchAllQuery;
import com.liferay.portal.search.query.QueryVisitor;

/**
 * @author Michael C. Han
 */
public class MatchAllQueryImpl extends BaseQueryImpl implements MatchAllQuery {

	@Override
	public <T> T accept(QueryVisitor<T> queryVisitor) {
		return queryVisitor.visit(this);
	}

	@Override
	public String toString() {
		Class<?> clazz = getClass();

		return "{className=" + clazz.getSimpleName() + "}";
	}

	private static final long serialVersionUID = 1L;

}