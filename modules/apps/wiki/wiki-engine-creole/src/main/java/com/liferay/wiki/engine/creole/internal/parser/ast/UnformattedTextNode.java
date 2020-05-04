/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

import com.liferay.wiki.engine.creole.internal.parser.visitor.ASTVisitor;

/**
 * @author Miguel Pastor
 */
public class UnformattedTextNode extends TextNode {

	public UnformattedTextNode(ASTNode astNode) {
		super(astNode);
	}

	public UnformattedTextNode(int tokenType) {
		super(tokenType);
	}

	public UnformattedTextNode(String content) {
		super(content);
	}

	@Override
	public void accept(ASTVisitor astVisitor) {
		astVisitor.visit(this);
	}

}