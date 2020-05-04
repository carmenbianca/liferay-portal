/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.filter;

import com.liferay.petra.string.StringBundler;

/**
 * @author Michael C. Han
 */
public class ExistsFilter extends BaseFilter {

	public ExistsFilter(String field) {
		_field = field;
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
		return 1;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{(");
		sb.append(_field);
		sb.append("), ");
		sb.append(super.toString());
		sb.append("}");

		return sb.toString();
	}

	private final String _field;

}