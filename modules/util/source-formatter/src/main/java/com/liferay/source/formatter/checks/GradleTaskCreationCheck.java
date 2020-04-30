/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.parser.GradleFile;

/**
 * @author Peter Shin
 */
public class GradleTaskCreationCheck extends BaseGradleFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, GradleFile gradleFile,
		String content) {

		if (absolutePath.contains("/project-templates-")) {
			return content;
		}

		String[] lines = StringUtil.splitLines(content);

		for (String line : lines) {
			if (line.matches("^task\\s+.*$") && line.contains("{")) {
				addMessage(
					fileName,
					"The task should be declared in a separate line before " +
						"the closure",
					getLineNumber(content, content.indexOf(line)));
			}
		}

		return content;
	}

}