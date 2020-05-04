/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Hugo Huijser
 */
public class SourceFormatterExcludes {

	public SourceFormatterExcludes() {
	}

	public SourceFormatterExcludes(
		Set<ExcludeSyntaxPattern> defaultExcludeSyntaxPatterns) {

		_defaultExcludeSyntaxPatterns = defaultExcludeSyntaxPatterns;
	}

	public void addDefaultExcludeSyntaxPatterns(
		List<ExcludeSyntaxPattern> defaultExcludeSyntaxPatterns) {

		_defaultExcludeSyntaxPatterns.addAll(defaultExcludeSyntaxPatterns);
	}

	public void addExcludeSyntaxPatterns(
		String propertiesFileLocation,
		List<ExcludeSyntaxPattern> excludeSyntaxPatterns) {

		_excludeSyntaxPatternsMap.put(
			propertiesFileLocation, excludeSyntaxPatterns);
	}

	public Set<ExcludeSyntaxPattern> getDefaultExcludeSyntaxPatterns() {
		return _defaultExcludeSyntaxPatterns;
	}

	public Map<String, List<ExcludeSyntaxPattern>>
		getExcludeSyntaxPatternsMap() {

		return _excludeSyntaxPatternsMap;
	}

	private Set<ExcludeSyntaxPattern> _defaultExcludeSyntaxPatterns =
		new HashSet<>();
	private Map<String, List<ExcludeSyntaxPattern>> _excludeSyntaxPatternsMap =
		new HashMap<>();

}