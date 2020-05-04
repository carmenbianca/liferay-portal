/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query;

import com.liferay.portal.search.query.MatchPhraseQuery;
import com.liferay.portal.search.query.QueryVisitor;

/**
 * @author Michael C. Han
 */
public class MatchPhraseQueryImpl
	extends BaseQueryImpl implements MatchPhraseQuery {

	public MatchPhraseQueryImpl(String field, Object value) {
		_field = field;
		_value = value;
	}

	@Override
	public <T> T accept(QueryVisitor<T> queryVisitor) {
		return queryVisitor.visit(this);
	}

	public String getAnalyzer() {
		return _analyzer;
	}

	public String getField() {
		return _field;
	}

	public Integer getSlop() {
		return _slop;
	}

	public Object getValue() {
		return _value;
	}

	public void setAnalyzer(String analyzer) {
		_analyzer = analyzer;
	}

	public void setSlop(Integer slop) {
		_slop = slop;
	}

	private static final long serialVersionUID = 1L;

	private String _analyzer;
	private final String _field;
	private Integer _slop;
	private final Object _value;

}