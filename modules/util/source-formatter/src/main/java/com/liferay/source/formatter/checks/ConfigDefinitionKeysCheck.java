/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.NaturalOrderStringComparator;

/**
 * @author Peter Shin
 */
public class ConfigDefinitionKeysCheck extends BaseDefinitionKeysCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		return sortDefinitionKeys(
			content, getDefinitions(content),
			new NaturalOrderStringComparator());
	}

}