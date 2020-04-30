/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.sort;

import com.liferay.portal.kernel.search.Sort;

import org.elasticsearch.search.builder.SearchSourceBuilder;

/**
 * @author Michael C. Han
 */
public interface SortTranslator {

	public void translate(
		SearchSourceBuilder searchSourceBuilder, Sort[] sorts);

}