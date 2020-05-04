/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.sort;

import com.liferay.portal.search.sort.Sort;
import com.liferay.portal.search.sort.SortOrder;

/**
 * @author Michael C. Han
 */
public abstract class SortImpl implements Sort {

	@Override
	public SortOrder getSortOrder() {
		if (_sortOrder != null) {
			return _sortOrder;
		}

		return SortOrder.ASC;
	}

	@Override
	public void setSortOrder(SortOrder sortOrder) {
		_sortOrder = sortOrder;
	}

	private SortOrder _sortOrder;

}