/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.suggest;

import com.liferay.portal.kernel.search.SearchContext;

/**
 * @author Michael C. Han
 */
public interface SuggesterTranslator<T> {

	public T translate(Suggester suggester, SearchContext searchContext);

}