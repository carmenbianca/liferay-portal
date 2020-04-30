/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

/**
 * @author Hugo Huijser
 */
public class XMLWhitespaceCheck extends WhitespaceCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		content = StringUtil.replace(content, "\"/>\n", "\" />\n");

		return super.doProcess(fileName, absolutePath, content);
	}

	@Override
	protected String formatDoubleSpace(String line) {
		if (line.contains("<contains") || line.contains("<replacetoken") ||
			line.contains("<replacevalue")) {

			return line;
		}

		return super.formatDoubleSpace(line);
	}

	@Override
	protected boolean isAllowLeadingSpaces(
		String fileName, String absolutePath) {

		if (fileName.startsWith(getBaseDirName() + "build") ||
			fileName.contains("/build")) {

			return true;
		}

		return false;
	}

}