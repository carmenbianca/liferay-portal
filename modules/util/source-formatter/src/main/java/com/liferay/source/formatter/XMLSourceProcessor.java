/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import com.liferay.source.formatter.checks.util.SourceUtil;
import com.liferay.source.formatter.checks.util.XMLSourceUtil;

import java.io.File;
import java.io.IOException;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class XMLSourceProcessor extends BaseSourceProcessor {

	@Override
	protected List<String> doGetFileNames() throws IOException {
		String[] excludes = {
			"**/.bnd/**", "**/.idea/**", "**/.ivy/**", "**/bin/**",
			"**/javadocs-*.xml", "**/logs/**", "**/portal-impl/**/*.action",
			"**/portal-impl/**/*.function", "**/portal-impl/**/*.macro",
			"**/portal-impl/**/*.testcase", "**/src/test/**",
			"**/test-classes/unit/**", "**/test-results/**", "**/test/unit/**",
			"**/tools/node**"
		};

		return getFileNames(excludes, getIncludes());
	}

	@Override
	protected String[] doGetIncludes() {
		return _INCLUDES;
	}

	@Override
	protected File format(
			File file, String fileName, String absolutePath, String content)
		throws Exception {

		if ((fileName.endsWith(".function") || fileName.endsWith(".macro") ||
			 fileName.endsWith(".testcase")) &&
			!SourceUtil.isXML(content)) {

			return file;
		}

		return super.format(file, fileName, absolutePath, content);
	}

	@Override
	protected boolean hasGeneratedTag(String content) {
		return _hasGeneratedTag(content, "@generated", "<!-- Generated");
	}

	private boolean _hasGeneratedTag(String content, String... tags) {
		for (String tag : tags) {
			if (!content.contains(tag)) {
				continue;
			}

			int pos = -1;

			while (true) {
				pos = content.indexOf(tag, pos + 1);

				if (pos == -1) {
					break;
				}

				if (!XMLSourceUtil.isInsideCDATAMarkup(content, pos)) {
					return true;
				}
			}
		}

		return false;
	}

	private static final String[] _INCLUDES = {
		"**/*.action", "**/*.function", "**/*.jrxml", "**/*.macro", "**/*.pom",
		"**/*.testcase", "**/*.toggle", "**/*.wsdl", "**/*.xml",
		"**/definitions/liferay-*.xsd"
	};

}