/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

import com.liferay.petra.string.StringPool;

/**
 * @author Adolfo Pérez
 */
public enum WildcardMode {

	LEADING(StringPool.PERCENT, StringPool.BLANK),
	SURROUND(StringPool.PERCENT, StringPool.PERCENT),
	TRAILING(StringPool.BLANK, StringPool.PERCENT);

	public String getLeadingWildcard() {
		return _leadingWildcard;
	}

	public String getTrailingWildcard() {
		return _trailingWildcard;
	}

	private WildcardMode(String leadingWildcard, String trailingWildcard) {
		_leadingWildcard = leadingWildcard;
		_trailingWildcard = trailingWildcard;
	}

	private final String _leadingWildcard;
	private final String _trailingWildcard;

}