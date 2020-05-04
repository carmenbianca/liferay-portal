/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.filter;

import com.liferay.petra.string.StringBundler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public class TermsFilter extends BaseFilter {

	public TermsFilter(String field) {
		_field = field;
	}

	@Override
	public <T> T accept(FilterVisitor<T> filterVisitor) {
		return filterVisitor.visit(this);
	}

	public void addValue(String value) {
		_values.add(value);
	}

	public void addValues(String... values) {
		Collections.addAll(_values, values);
	}

	public String getField() {
		return _field;
	}

	@Override
	public int getSortOrder() {
		return 4;
	}

	public String[] getValues() {
		return _values.toArray(new String[0]);
	}

	public boolean isEmpty() {
		return _values.isEmpty();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{(");
		sb.append(_field);
		sb.append("=");
		sb.append(_values);
		sb.append("), ");
		sb.append(super.toString());
		sb.append("}");

		return sb.toString();
	}

	private final String _field;
	private final Set<String> _values = new HashSet<>();

}