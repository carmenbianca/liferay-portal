/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.language;

/**
 * @author Brian Wing Shun Chan
 */
public class LanguageWrapper {

	public LanguageWrapper(String before, String text, String after) {
		_before = before;
		_text = text;
		_after = after;
	}

	public String getAfter() {
		return _after;
	}

	public String getBefore() {
		return _before;
	}

	public String getText() {
		return _text;
	}

	private final String _after;
	private final String _before;
	private final String _text;

}