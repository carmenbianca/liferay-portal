/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.query;

import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;

/**
 * @author André de Oliveira
 * @author Miguel Angelo Caldas Gallindo
 */
public interface QueryTranslator<T> {

	public T translate(Query query, SearchContext searchContext);

}