/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

import com.liferay.wiki.engine.creole.internal.parser.visitor.ASTVisitor;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

/**
 * @author Miguel Pastor
 */
public class WikiPageNode extends BaseParentableNode {

	public WikiPageNode(CollectionNode collectionNode) {
		super(collectionNode);
	}

	public WikiPageNode(int tokenType) {
		this(new CommonToken(tokenType), null);
	}

	public WikiPageNode(Token token, CollectionNode collectionNode) {
		super(collectionNode);
	}

	@Override
	public void accept(ASTVisitor astVisitor) {
		astVisitor.visit(this);
	}

}