/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.elements;

import com.liferay.poshi.runner.script.PoshiScriptParserException;

import org.dom4j.Comment;

/**
 * @author Kenji Heigel
 */
public class MultilinePoshiComment extends PoshiComment {

	@Override
	public PoshiComment clone(Comment comment) {
		String commentText = comment.getText();

		if (commentText.contains("\n")) {
			return new MultilinePoshiComment(comment);
		}

		return null;
	}

	@Override
	public PoshiComment clone(String poshiScript)
		throws PoshiScriptParserException {

		if (isPoshiScriptComment(poshiScript)) {
			return new MultilinePoshiComment(poshiScript);
		}

		return null;
	}

	@Override
	public boolean isPoshiScriptComment(String poshiScript) {
		poshiScript = poshiScript.trim();

		if (poshiScript.endsWith("*/") && poshiScript.startsWith("/*")) {
			return true;
		}

		return false;
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {

		String text = poshiScript.substring(2, poshiScript.length() - 2);

		setText(text);
	}

	@Override
	public String toPoshiScript() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\t/*");
		sb.append(getText());
		sb.append("*/");

		return sb.toString();
	}

	protected MultilinePoshiComment() {
	}

	protected MultilinePoshiComment(Comment comment) {
		super(comment);
	}

	protected MultilinePoshiComment(String poshiScript)
		throws PoshiScriptParserException {

		super(poshiScript);
	}

}