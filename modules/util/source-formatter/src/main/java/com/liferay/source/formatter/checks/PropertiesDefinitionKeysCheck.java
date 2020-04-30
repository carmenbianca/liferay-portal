/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.NaturalOrderStringComparator;

/**
 * @author Hugo Huijser
 */
public class PropertiesDefinitionKeysCheck extends BaseDefinitionKeysCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (fileName.endsWith("/liferay-plugin-package.properties") ||
			fileName.endsWith("/TLiferayBatchFileProperties.properties")) {

			content = sortDefinitionKeys(
				content, getDefinitions(content),
				new NaturalOrderStringComparator());
		}

		return content;
	}

}