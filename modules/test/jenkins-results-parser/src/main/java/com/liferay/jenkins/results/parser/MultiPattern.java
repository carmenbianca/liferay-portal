/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Yoo
 */
public class MultiPattern {

	public MultiPattern(String... patternStrings) {
		_patterns = new ArrayList<>(patternStrings.length);

		for (String patternString : patternStrings) {
			_patterns.add(Pattern.compile(patternString));
		}
	}

	public Matcher find(String input) {
		for (Pattern pattern : _patterns) {
			Matcher matcher = pattern.matcher(input);

			if (matcher.find()) {
				return matcher;
			}
		}

		return null;
	}

	public int getSize() {
		return _patterns.size();
	}

	public int indexOf(Pattern pattern) {
		return _patterns.indexOf(pattern);
	}

	public Matcher matches(String input) {
		for (Pattern pattern : _patterns) {
			Matcher matcher = pattern.matcher(input);

			if (matcher.matches()) {
				return matcher;
			}
		}

		return null;
	}

	private final List<Pattern> _patterns;

}