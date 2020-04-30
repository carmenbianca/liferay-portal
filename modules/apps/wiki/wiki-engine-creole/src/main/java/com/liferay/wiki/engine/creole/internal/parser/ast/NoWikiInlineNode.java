/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

import com.liferay.wiki.engine.creole.internal.parser.visitor.ASTVisitor;

/**
 * @author István András Dézsi
 */
public class NoWikiInlineNode extends ASTNode {

	public NoWikiInlineNode(int tokenType) {
		this(tokenType, null);
	}

	public NoWikiInlineNode(int tokenType, String content) {
		super(tokenType);

		_content = content;
	}

	public NoWikiInlineNode(String content) {
		_content = content;
	}

	@Override
	public void accept(ASTVisitor astVisitor) {
		astVisitor.visit(this);
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private String _content;

}