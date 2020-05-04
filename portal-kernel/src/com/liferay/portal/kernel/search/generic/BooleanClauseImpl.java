/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.generic;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;

/**
 * @author Michael C. Han
 */
public class BooleanClauseImpl<T> implements BooleanClause<T> {

	public BooleanClauseImpl(T t, BooleanClauseOccur booleanClauseOccur) {
		_t = t;
		_booleanClauseOccur = booleanClauseOccur;
	}

	@Override
	public BooleanClauseOccur getBooleanClauseOccur() {
		return _booleanClauseOccur;
	}

	@Override
	public T getClause() {
		return _t;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{");
		sb.append(_booleanClauseOccur);
		sb.append("(");
		sb.append(_t);
		sb.append(")}");

		return sb.toString();
	}

	private final BooleanClauseOccur _booleanClauseOccur;
	private final T _t;

}