/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

/**
 * @author Hugo Huijser
 */
public class CodeownersFileLocationCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (!fileName.endsWith("/.github/CODEOWNERS")) {
			addMessage(
				fileName,
				"CODEOWNERS file should be located in directory '.github'");
		}

		return content;
	}

}