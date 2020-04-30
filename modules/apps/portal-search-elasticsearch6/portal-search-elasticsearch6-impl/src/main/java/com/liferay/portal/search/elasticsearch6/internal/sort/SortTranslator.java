/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.sort;

import com.liferay.portal.kernel.search.Sort;

import org.elasticsearch.action.search.SearchRequestBuilder;

/**
 * @author Michael C. Han
 */
public interface SortTranslator {

	public void translate(
		SearchRequestBuilder searchRequestBuilder, Sort[] sorts);

}