/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.sort;

import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.sort.NestedSort;

/**
 * @author Michael C. Han
 */
public class NestedSortImpl implements NestedSort {

	public NestedSortImpl(String path) {
		_path = path;
	}

	public Query getFilterQuery() {
		return _filterQuery;
	}

	public int getMaxChildren() {
		return _maxChildren;
	}

	public NestedSort getNestedSort() {
		return _nestedSort;
	}

	public String getPath() {
		return _path;
	}

	public void setFilterQuery(Query filterQuery) {
		_filterQuery = filterQuery;
	}

	public void setMaxChildren(int maxChildren) {
		_maxChildren = maxChildren;
	}

	public void setNestedSort(NestedSort nestedSort) {
		_nestedSort = nestedSort;
	}

	private Query _filterQuery;
	private int _maxChildren = Integer.MAX_VALUE;
	private NestedSort _nestedSort;
	private final String _path;

}