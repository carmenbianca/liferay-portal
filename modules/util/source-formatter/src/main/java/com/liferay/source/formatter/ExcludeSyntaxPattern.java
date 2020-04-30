/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;

import java.util.regex.Pattern;

/**
 * @author Peter Shin
 */
public class ExcludeSyntaxPattern {

	public ExcludeSyntaxPattern(
		ExcludeSyntax excludeSyntax, String excludePattern) {

		_excludeSyntax = excludeSyntax;

		if (_excludeSyntax == ExcludeSyntax.REGEX) {
			_excludePattern = StringUtil.replace(
				excludePattern, CharPool.SLASH, Pattern.quote(File.separator));
		}
		else {
			_excludePattern = excludePattern;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExcludeSyntaxPattern)) {
			return false;
		}

		ExcludeSyntaxPattern excludeSyntaxPattern = (ExcludeSyntaxPattern)obj;

		ExcludeSyntax excludeSyntax = excludeSyntaxPattern.getExcludeSyntax();

		if (!excludeSyntax.equals(_excludeSyntax)) {
			return false;
		}

		String excludePattern = excludeSyntaxPattern.getExcludePattern();

		if (!excludePattern.equals(_excludePattern)) {
			return false;
		}

		return true;
	}

	public String getExcludePattern() {
		return _excludePattern;
	}

	public ExcludeSyntax getExcludeSyntax() {
		return _excludeSyntax;
	}

	@Override
	public int hashCode() {
		String s = _excludeSyntax.getValue();

		s = s.concat(_excludePattern);

		return s.hashCode();
	}

	private final String _excludePattern;
	private final ExcludeSyntax _excludeSyntax;

}