/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.display.context;

import com.liferay.petra.string.CharPool;

/**
 * @author André de Oliveira
 */
public class Keywords {

	public Keywords(String keywords) {
		boolean luceneSyntax = false;

		if ((keywords.length() > 1) && (keywords.charAt(0) == CharPool.STAR)) {
			keywords = keywords.substring(1);

			luceneSyntax = true;
		}

		_keywords = keywords;
		_luceneSyntax = luceneSyntax;
	}

	public String getKeywords() {
		return _keywords;
	}

	public boolean isLuceneSyntax() {
		return _luceneSyntax;
	}

	private final String _keywords;
	private final boolean _luceneSyntax;

}