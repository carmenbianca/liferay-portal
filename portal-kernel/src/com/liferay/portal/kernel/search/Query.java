/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.query.QueryVisitor;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public interface Query extends Serializable {

	public static final float BOOST_DEFAULT = 1.0F;

	public <T> T accept(QueryVisitor<T> queryVisitor);

	public float getBoost();

	public Filter getPostFilter();

	public BooleanFilter getPreBooleanFilter();

	public QueryConfig getQueryConfig();

	public boolean hasChildren();

	public boolean isDefaultBoost();

	public void setBoost(float boost);

	public void setPostFilter(Filter filter);

	public void setPreBooleanFilter(BooleanFilter preBooleanFilter);

	public void setQueryConfig(QueryConfig queryConfig);

}