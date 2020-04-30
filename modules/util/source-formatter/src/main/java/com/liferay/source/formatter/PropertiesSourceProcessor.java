/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import java.io.IOException;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class PropertiesSourceProcessor extends BaseSourceProcessor {

	@Override
	protected List<String> doGetFileNames() throws IOException {
		return getFileNames(
			new String[] {"**/docroot/dtd/**", "**/lportal.properties"},
			getIncludes());
	}

	@Override
	protected String[] doGetIncludes() {
		if (isPortalSource() || isSubrepository()) {
			return _INCLUDES;
		}

		return new String[] {
			"**/liferay-plugin-package.properties", "**/portal.properties",
			"**/portal-ext.properties", "**/portlet.properties",
			"**/service.properties", "**/source-formatter.properties"
		};
	}

	private static final String[] _INCLUDES = {
		"**/*.properties", "**/*.prettierignore"
	};

}