/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.sort;

/**
 * @author Michael C. Han
 */
public interface SortFieldBuilder {

	public String getSortField(String entityClassName, String orderByCol);

	public String getSortField(
		String entityClassName, String orderByCol, int sortType);

}