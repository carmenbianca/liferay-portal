/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.search.request;

import com.liferay.portal.kernel.search.SearchContext;

/**
 * @author André de Oliveira
 */
public interface SearchContextBuilder {

	public SearchContext getSearchContext();

}