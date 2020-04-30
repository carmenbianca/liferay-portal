/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

/**
 * @author André de Oliveira
 */
public interface ExpandoQueryContributor {

	public void contribute(
		String keywords, BooleanQuery booleanQuery, String[] classNames,
		SearchContext searchContext);

}