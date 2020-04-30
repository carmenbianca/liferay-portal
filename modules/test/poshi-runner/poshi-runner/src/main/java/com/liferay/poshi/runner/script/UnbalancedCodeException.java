/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.script;

/**
 * @author Kenji Heigel
 */
public class UnbalancedCodeException extends PoshiScriptParserException {

	public UnbalancedCodeException(String msg, int index, String code) {
		super(msg);

		_processLine(index, code);
	}

	@Override
	public String getErrorSnippet() {
		return _errorSnippet;
	}

	public void setErrorSnippet(String errorSnippet) {
		_errorSnippet = errorSnippet;
	}

	private static String _getLine(int lineNumber, String code) {
		String[] lines = code.split("\n");

		return lines[lineNumber - 1].replace("\t", "    ");
	}

	private void _processLine(int index, String code) {
		int lineNumber = 1;

		int newLineIndex = -1;

		for (int i = 0; i < index; i++) {
			if (code.charAt(i) == '\n') {
				lineNumber++;

				newLineIndex = i;
			}
		}

		setErrorLineNumber(lineNumber);

		int column = 1;

		for (int i = newLineIndex + 1; i < index; i++) {
			if (code.charAt(i) == '\t') {
				column += 4;

				continue;
			}

			column++;
		}

		StringBuilder sb = new StringBuilder();

		sb.append(_getLine(lineNumber, code));
		sb.append("\n");

		for (int i = 1; i < column; i++) {
			sb.append(" ");
		}

		sb.append("^");

		setErrorSnippet(sb.toString());
	}

	private String _errorSnippet = "";

}