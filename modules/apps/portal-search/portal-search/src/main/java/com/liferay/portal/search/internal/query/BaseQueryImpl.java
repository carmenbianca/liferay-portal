/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query;

import com.liferay.portal.search.query.Query;

/**
 * @author Michael C. Han
 */
public abstract class BaseQueryImpl implements Query {

	@Override
	public Float getBoost() {
		return _boost;
	}

	@Override
	public String getQueryName() {
		return _queryName;
	}

	@Override
	public void setBoost(Float boost) {
		_boost = boost;
	}

	@Override
	public void setQueryName(String queryName) {
		_queryName = queryName;
	}

	private static final long serialVersionUID = 1L;

	private Float _boost;
	private String _queryName;

}