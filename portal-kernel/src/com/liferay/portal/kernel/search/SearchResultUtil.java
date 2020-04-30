/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.search.result.SearchResultTranslator;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eudaldo Alonso
 */
public class SearchResultUtil {

	public static List<SearchResult> getSearchResults(
		Hits hits, Locale locale) {

		return getSearchResults(hits, locale, null, null);
	}

	public static List<SearchResult> getSearchResults(
		Hits hits, Locale locale, PortletRequest portletRequest,
		PortletResponse portletResponse) {

		return _searchResultTranslator.translate(
			hits, locale, portletRequest, portletResponse);
	}

	private static volatile SearchResultTranslator _searchResultTranslator =
		ServiceProxyFactory.newServiceTrackedInstance(
			SearchResultTranslator.class, SearchResultUtil.class,
			"_searchResultTranslator", false);

}