/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.sort;

import java.util.List;

/**
 * Models a parser from string to sort fields.
 *
 * @author Cristina González
 * @review
 */
public interface SortParser {

	/**
	 * Returns a {@link SortField} list from a string.
	 *
	 * @param  sortString the string to parse
	 * @return the {@link SortField} list
	 * @review
	 */
	public List<SortField> parse(String sortString);

}