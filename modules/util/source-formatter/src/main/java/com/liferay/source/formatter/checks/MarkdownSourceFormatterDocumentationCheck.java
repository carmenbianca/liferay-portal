/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Hugo Huijser
 */
public class MarkdownSourceFormatterDocumentationCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (!absolutePath.contains(
				"/modules/util/source-formatter/src/main/resources" +
					"/documentation/checks/")) {

			return content;
		}

		int x = absolutePath.lastIndexOf(CharPool.SLASH);
		int y = absolutePath.lastIndexOf(CharPool.PERIOD);

		String expectedHeaderName = StringUtil.removeChar(
			absolutePath.substring(x + 1, y), CharPool.UNDERLINE);

		if (!StringUtil.startsWith(
				content, "## " + expectedHeaderName + "\n")) {

			addMessage(
				fileName,
				"There should be a header name corresponding with the name " +
					"of the documented check");
		}

		return content;
	}

}