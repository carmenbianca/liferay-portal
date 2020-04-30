/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

/**
 * @author Brian Wing Shun Chan
 */
public class DocumentComparatorOrderBy {

	public DocumentComparatorOrderBy(
		String name, boolean asc, boolean caseSensitive) {

		_name = name;
		_asc = asc;
		_caseSensitive = caseSensitive;
	}

	public String getName() {
		return _name;
	}

	public boolean isAsc() {
		return _asc;
	}

	public boolean isCaseSensitive() {
		return _caseSensitive;
	}

	private final boolean _asc;
	private final boolean _caseSensitive;
	private final String _name;

}