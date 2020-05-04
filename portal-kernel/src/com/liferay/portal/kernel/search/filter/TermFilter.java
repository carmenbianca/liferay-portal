/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.filter;

import com.liferay.petra.string.StringBundler;

/**
 * @author Michael C. Han
 */
public class TermFilter extends BaseFilter {

	public TermFilter(String field, String value) {
		_field = field;
		_value = value;
	}

	@Override
	public <T> T accept(FilterVisitor<T> filterVisitor) {
		return filterVisitor.visit(this);
	}

	public String getField() {
		return _field;
	}

	@Override
	public int getSortOrder() {
		return 3;
	}

	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{(");
		sb.append(_field);
		sb.append("=");
		sb.append(_value);
		sb.append("), ");
		sb.append(super.toString());
		sb.append("}");

		return sb.toString();
	}

	private final String _field;
	private final String _value;

}