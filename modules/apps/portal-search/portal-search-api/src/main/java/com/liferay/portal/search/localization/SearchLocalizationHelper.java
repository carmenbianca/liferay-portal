/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.localization;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;

import java.util.Locale;
import java.util.Map;

/**
 * @author Adam Brandizzi
 */
public interface SearchLocalizationHelper {

	public void addLocalizedField(
		Document document, String field, Locale defaultLocale,
		Map<Locale, String> map);

	public Locale[] getLocales(SearchContext searchContext);

	public String[] getLocalizedFieldNames(
		String[] prefixes, SearchContext searchContext);

}