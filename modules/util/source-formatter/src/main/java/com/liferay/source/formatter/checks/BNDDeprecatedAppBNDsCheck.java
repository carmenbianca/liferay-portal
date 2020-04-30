/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

/**
 * @author Hugo Huijser
 */
public class BNDDeprecatedAppBNDsCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (absolutePath.endsWith("/app.bnd") &&
			absolutePath.contains("modules/apps/archived")) {

			addMessage(
				fileName,
				"Module in 'archived' directory should not have 'app.bnd'");
		}

		return content;
	}

}