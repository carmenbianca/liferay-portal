/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;

import java.io.IOException;

/**
 * @author Alan Huang
 */
public class YMLLongLinesCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		int maxLineLength = 0;

		try {
			maxLineLength = Integer.parseInt(
				getAttributeValue(_MAX_LINE_LENGTH, absolutePath));
		}
		catch (NumberFormatException numberFormatException) {
			return content;
		}

		try (UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new UnsyncStringReader(content))) {

			int lineNumber = 0;

			String line = null;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				if (line.matches(" +-")) {
					continue;
				}

				lineNumber++;

				if (getLineLength(line) > maxLineLength) {
					addMessage(fileName, "> " + maxLineLength, lineNumber);
				}
			}
		}

		return content;
	}

	private static final String _MAX_LINE_LENGTH = "maxLineLength";

}