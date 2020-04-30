/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.elements;

import com.liferay.poshi.runner.script.PoshiScriptParserException;
import com.liferay.poshi.runner.util.PropsValues;

import org.dom4j.Comment;
import org.dom4j.tree.DefaultComment;

/**
 * @author Michael Hashimoto
 */
public abstract class PoshiComment
	extends DefaultComment implements PoshiNode<Comment, PoshiComment> {

	public PoshiComment() {
		super(null);
	}

	@Override
	public String getPoshiScript() {
		return _poshiScript;
	}

	public abstract boolean isPoshiScriptComment(String poshiScript);

	@Override
	public void setPoshiScript(String poshiScript) {
		_poshiScript = poshiScript;
	}

	protected PoshiComment(Comment comment) {
		super(comment.getText());
	}

	protected PoshiComment(String poshiScript)
		throws PoshiScriptParserException {

		this();

		setPoshiScript(poshiScript);

		parsePoshiScript(poshiScript.trim());

		if (PropsValues.TEST_POSHI_SCRIPT_VALIDATION) {
			validatePoshiScript();
		}
	}

	private String _poshiScript;

}