/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

import com.liferay.wiki.engine.creole.internal.parser.visitor.ASTVisitor;

/**
 * @author Miguel Pastor
 */
public class NoWikiSectionNode extends ASTNode {

	public NoWikiSectionNode(int tokenType) {
		this(tokenType, null);
	}

	public NoWikiSectionNode(int tokenType, String content) {
		super(tokenType);

		_content = content;
	}

	public NoWikiSectionNode(String content) {
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