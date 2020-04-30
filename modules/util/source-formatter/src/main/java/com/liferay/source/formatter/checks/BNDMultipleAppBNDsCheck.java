/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

/**
 * @author Hugo Huijser
 */
public class BNDMultipleAppBNDsCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		if (!absolutePath.endsWith("/app.bnd")) {
			return content;
		}

		_checkMuldipleAppBND(fileName, absolutePath, "dxp");
		_checkMuldipleAppBND(fileName, absolutePath, "private");

		return content;
	}

	private void _checkMuldipleAppBND(
			String fileName, String absolutePath, String dirName)
		throws IOException {

		int x = absolutePath.indexOf("/modules/" + dirName + "/apps/");

		if (x == -1) {
			return;
		}

		String portalAppBNDFileName = StringUtil.replaceFirst(
			absolutePath.substring(x + 1), "/" + dirName + "/", "/");

		if (getPortalContent(portalAppBNDFileName, absolutePath, true) !=
				null) {

			addMessage(
				fileName,
				"Redundant app.bnd. There is one already: '" +
					portalAppBNDFileName + "'.");
		}
	}

}