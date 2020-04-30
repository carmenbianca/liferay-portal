/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

import com.liferay.wiki.engine.creole.internal.parser.visitor.ASTVisitor;

/**
 * @author Miguel Pastor
 */
public class OrderedListItemNode extends ItemNode {

	public OrderedListItemNode(int tokenType) {
		super(tokenType);
	}

	public OrderedListItemNode(
		int level, BaseParentableNode baseParentableNode,
		CollectionNode collectionNode) {

		super(level, baseParentableNode, collectionNode);
	}

	@Override
	public void accept(ASTVisitor astVisitor) {
		astVisitor.visit(this);
	}

}