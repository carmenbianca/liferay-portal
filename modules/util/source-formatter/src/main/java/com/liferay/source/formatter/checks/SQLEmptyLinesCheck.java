/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Hugo Huijser
 */
public class SQLEmptyLinesCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		String[] lines = StringUtil.splitLines(content);

		for (int i = 1; i < lines.length; i++) {
			String line = lines[i];
			String previousLine = lines[i - 1];

			if (Validator.isNull(line) || line.startsWith("\t") ||
				Validator.isNull(previousLine) ||
				previousLine.startsWith("\t")) {

				continue;
			}

			String previousSQLCommand = _getSQLCommand(previousLine);
			String sqlCommand = _getSQLCommand(line);

			if (!previousSQLCommand.equals(sqlCommand)) {
				return StringUtil.replace(
					content, previousLine + "\n" + line,
					previousLine + "\n\n" + line);
			}
		}

		return content;
	}

	private String _getSQLCommand(String line) {
		String[] words = StringUtil.split(line, CharPool.SPACE);

		return words[0];
	}

}