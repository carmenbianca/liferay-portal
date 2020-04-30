/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Hugo Huijser
 */
public class MarkdownWhitespaceCheck extends WhitespaceCheck {

	@Override
	protected String formatDoubleSpace(String line) {
		String trimmedLine = StringUtil.trim(line);

		if (trimmedLine.startsWith("*") || trimmedLine.matches("[0-9]+\\..*")) {
			return line;
		}

		return super.formatDoubleSpace(line);
	}

}