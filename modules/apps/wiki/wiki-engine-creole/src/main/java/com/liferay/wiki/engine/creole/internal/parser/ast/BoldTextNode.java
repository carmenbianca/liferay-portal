/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

import com.liferay.wiki.engine.creole.internal.parser.visitor.ASTVisitor;

/**
 * @author Miguel Pastor
 */
public class BoldTextNode extends FormattedTextNode {

	public BoldTextNode(ASTNode astNode) {
		super(astNode);
	}

	@Override
	public void accept(ASTVisitor astVisitor) {
		astVisitor.visit(this);
	}

	@Override
	public boolean hasContent() {
		if ((getChildASTNodes() == null) && (getContent() == null)) {
			return false;
		}

		return true;
	}

}