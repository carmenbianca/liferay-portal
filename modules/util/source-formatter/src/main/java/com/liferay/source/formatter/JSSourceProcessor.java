/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import java.io.IOException;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class JSSourceProcessor extends BaseSourceProcessor {

	@Override
	protected List<String> doGetFileNames() throws IOException {
		String[] excludes = {
			"**/*.es.js", "**/*.min.js", "**/*.nocsf.js", "**/*.soy.js",
			"**/aui/**", "**/jquery/**", "**/lodash/**", "**/misc/**",
			"**/r2.js", "**/tools/**"
		};

		return getFileNames(excludes, getIncludes());
	}

	@Override
	protected String[] doGetIncludes() {
		return _INCLUDES;
	}

	private static final String[] _INCLUDES = {"**/*.js", "**/*.jsx"};

}