/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

/**
 * @author Hugo Huijser
 */
public class JavaLogParametersCheck extends BaseLogParametersCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (content.contains("import com.liferay.portal.kernel.log.Log;")) {
			return formatLogParameters(content);
		}

		return content;
	}

}