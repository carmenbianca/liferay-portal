/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.sort;

import com.liferay.portal.search.sort.ScoreSort;
import com.liferay.portal.search.sort.SortVisitor;

/**
 * @author Michael C. Han
 */
public class ScoreSortImpl extends SortImpl implements ScoreSort {

	@Override
	public <T> T accept(SortVisitor<T> sortVisitor) {
		return sortVisitor.visit(this);
	}

}