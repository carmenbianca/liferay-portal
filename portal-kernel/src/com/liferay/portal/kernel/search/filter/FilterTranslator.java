/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.filter;

import com.liferay.portal.kernel.search.SearchContext;

/**
 * @author Michael C. Han
 */
public interface FilterTranslator<T> {

	public T translate(Filter filter, SearchContext searchContext);

}