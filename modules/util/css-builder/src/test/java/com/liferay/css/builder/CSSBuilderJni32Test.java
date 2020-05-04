/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.css.builder;

import java.nio.file.Path;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Andrea Di Giorgi
 */
@RunWith(Parameterized.class)
public class CSSBuilderJni32Test extends BaseCSSBulderJni32TestCase {

	@Parameterized.Parameters(name = "{0}")
	public static String[] getSeparators() {
		return new String[] {"=", " "};
	}

	public CSSBuilderJni32Test(String separator) {
		_separator = separator;
	}

	@Override
	protected String executeCSSBuilder(
			Path docrootDirPath, String dirName, String[] excludes,
			boolean generateSourceMap, Path portalCommonPath,
			String outputDirName, int precision,
			String[] rtlExcludedPathRegexps, String sassCompilerClassName)
		throws Exception {

		return CSSBuilderTestUtil.executeCSSBuilder(
			_separator, docrootDirPath, dirName, excludes, generateSourceMap,
			portalCommonPath, outputDirName, precision, rtlExcludedPathRegexps,
			sassCompilerClassName);
	}

	private final String _separator;

}