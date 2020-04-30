/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

/**
 * @author Hugo Huijser
 */
public class IncorrectFileLocationCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (!fileName.endsWith(".java") &&
			!absolutePath.contains("/src/main/resources/") &&
			absolutePath.matches(".*\\/modules\\/.*\\/src\\/.*\\/java\\/.*")) {

			addMessage(
				fileName, "Only *.java files are allowed in /src/*/java/");
		}

		return content;
	}

}