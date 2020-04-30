/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.elements;

import com.liferay.poshi.runner.script.PoshiScriptParserException;
import com.liferay.poshi.runner.util.StringUtil;

import org.dom4j.Comment;

/**
 * @author Peter Yoo
 */
public class InlinePoshiComment extends PoshiComment {

	@Override
	public PoshiComment clone(Comment comment) {
		String commentText = comment.getText();

		if (!commentText.contains("\n")) {
			return new InlinePoshiComment(comment);
		}

		return null;
	}

	@Override
	public PoshiComment clone(String poshiScript)
		throws PoshiScriptParserException {

		if (isPoshiScriptComment(poshiScript)) {
			return new InlinePoshiComment(poshiScript);
		}

		return null;
	}

	@Override
	public boolean isPoshiScriptComment(String poshiScript) {
		poshiScript = poshiScript.trim();

		if (poshiScript.startsWith("//")) {
			return true;
		}

		return false;
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {

		if (isPoshiScriptComment(poshiScript)) {
			String text = poshiScript.substring(2);

			setText(" " + text.trim() + " ");
		}
	}

	@Override
	public String toPoshiScript() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\n\t//");
		sb.append(StringUtil.trimTrailing(getText()));

		return sb.toString();
	}

	protected InlinePoshiComment() {
	}

	protected InlinePoshiComment(Comment comment) {
		super(comment);
	}

	protected InlinePoshiComment(String poshiScript)
		throws PoshiScriptParserException {

		super(poshiScript);
	}

}