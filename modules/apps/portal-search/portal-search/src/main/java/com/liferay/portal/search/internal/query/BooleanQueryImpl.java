/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.query.QueryVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael C. Han
 * @author Hugo Huijser
 */
public class BooleanQueryImpl extends BaseQueryImpl implements BooleanQuery {

	@Override
	public <T> T accept(QueryVisitor<T> queryVisitor) {
		return queryVisitor.visit(this);
	}

	public BooleanQuery addFilterQueryClauses(Query... clauses) {
		if (ArrayUtil.isEmpty(clauses)) {
			return this;
		}

		Collections.addAll(_filterQueryClauses, clauses);

		return this;
	}

	public BooleanQuery addMustNotQueryClauses(Query... clauses) {
		if (ArrayUtil.isEmpty(clauses)) {
			return this;
		}

		Collections.addAll(_mustNotQueryClauses, clauses);

		return this;
	}

	public BooleanQuery addMustQueryClauses(Query... clauses) {
		if (ArrayUtil.isEmpty(clauses)) {
			return this;
		}

		Collections.addAll(_mustQueryClauses, clauses);

		return this;
	}

	public BooleanQuery addShouldQueryClauses(Query... clauses) {
		if (ArrayUtil.isEmpty(clauses)) {
			return this;
		}

		Collections.addAll(_shouldQueryClauses, clauses);

		return this;
	}

	public Boolean getAdjustPureNegative() {
		return _adjustPureNegative;
	}

	public List<Query> getFilterQueryClauses() {
		return Collections.unmodifiableList(_filterQueryClauses);
	}

	public Integer getMinimumShouldMatch() {
		return _minimumShouldMatch;
	}

	public List<Query> getMustNotQueryClauses() {
		return Collections.unmodifiableList(_mustNotQueryClauses);
	}

	public List<Query> getMustQueryClauses() {
		return Collections.unmodifiableList(_mustQueryClauses);
	}

	public List<Query> getShouldQueryClauses() {
		return Collections.unmodifiableList(_shouldQueryClauses);
	}

	public boolean hasClauses() {
		if (!_filterQueryClauses.isEmpty()) {
			return true;
		}

		if (!_mustQueryClauses.isEmpty()) {
			return true;
		}

		if (!_mustNotQueryClauses.isEmpty()) {
			return true;
		}

		if (!_shouldQueryClauses.isEmpty()) {
			return true;
		}

		return false;
	}

	public void setAdjustPureNegative(Boolean adjustPureNegative) {
		_adjustPureNegative = adjustPureNegative;
	}

	public void setMinimumShouldMatch(Integer minimumShouldMatch) {
		_minimumShouldMatch = minimumShouldMatch;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{className=");

		Class<?> clazz = getClass();

		sb.append(clazz.getSimpleName());

		sb.append(", filterQueryClauses=");
		sb.append(_filterQueryClauses);
		sb.append(", mustQueryClauses=");
		sb.append(_mustQueryClauses);
		sb.append(", mustNotQueryClauses=");
		sb.append(_mustNotQueryClauses);
		sb.append(", shouldQueryClauses=");
		sb.append(_shouldQueryClauses);
		sb.append("}");

		return sb.toString();
	}

	private static final long serialVersionUID = 1L;

	private Boolean _adjustPureNegative;
	private final List<Query> _filterQueryClauses = new ArrayList<>();
	private Integer _minimumShouldMatch;
	private final List<Query> _mustNotQueryClauses = new ArrayList<>();
	private final List<Query> _mustQueryClauses = new ArrayList<>();
	private final List<Query> _shouldQueryClauses = new ArrayList<>();

}