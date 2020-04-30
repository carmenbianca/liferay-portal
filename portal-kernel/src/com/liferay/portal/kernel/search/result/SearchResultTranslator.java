/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.result;

import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchResult;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author André de Oliveira
 */
public interface SearchResultTranslator {

	public List<SearchResult> translate(
		Hits hits, Locale locale, PortletRequest portletRequest,
		PortletResponse portletResponse);

}