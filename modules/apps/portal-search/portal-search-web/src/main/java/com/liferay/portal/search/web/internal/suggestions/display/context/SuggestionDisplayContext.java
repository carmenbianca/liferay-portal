/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.suggestions.display.context;

/**
 * @author Adam Brandizzi
 */
public class SuggestionDisplayContext {

	public String getSuggestedKeywordsFormatted() {
		return _suggestedKeywordsFormatted;
	}

	public String getURL() {
		return _url;
	}

	public void setSuggestedKeywordsFormatted(
		String suggestedKeywordsFormatted) {

		_suggestedKeywordsFormatted = suggestedKeywordsFormatted;
	}

	public void setURL(String url) {
		_url = url;
	}

	private String _suggestedKeywordsFormatted;
	private String _url;

}