/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.bucket.IncludeExcludeClause;

/**
 * @author Michael C. Han
 */
public class IncludeExcludeClauseImpl implements IncludeExcludeClause {

	public IncludeExcludeClauseImpl(String includeRegex, String excludeRegex) {
		_includeRegex = includeRegex;
		_excludeRegex = excludeRegex;
	}

	public IncludeExcludeClauseImpl(
		String[] includedValues, String[] excludedValues) {

		_includedValues = includedValues;
		_excludedValues = excludedValues;
	}

	@Override
	public String[] getExcludedValues() {
		return _excludedValues;
	}

	@Override
	public String getExcludeRegex() {
		return _excludeRegex;
	}

	@Override
	public String[] getIncludedValues() {
		return _includedValues;
	}

	@Override
	public String getIncludeRegex() {
		return _includeRegex;
	}

	private String[] _excludedValues;
	private String _excludeRegex;
	private String[] _includedValues;
	private String _includeRegex;

}