/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

import java.util.List;

/**
 * @author Miguel Pastor
 */
public abstract class BaseParentableNode extends ASTNode {

	public BaseParentableNode() {
		this(null, 0);
	}

	public BaseParentableNode(CollectionNode collectionNode) {
		this(collectionNode, 0);
	}

	public BaseParentableNode(int tokenType) {
		this(null, tokenType);
	}

	public void addChildASTNode(ASTNode astNode) {
		_collectionNode.add(astNode);
	}

	public ASTNode getChildASTNode(int position) {
		return _collectionNode.get(position);
	}

	public List<ASTNode> getChildASTNodes() {
		return _collectionNode.getASTNodes();
	}

	public int getChildASTNodesCount() {
		return _collectionNode.size();
	}

	protected BaseParentableNode(CollectionNode collectionNode, int tokenType) {
		super(tokenType);

		if (collectionNode != null) {
			_collectionNode = collectionNode;
		}
		else {
			_collectionNode = new CollectionNode();
		}
	}

	private final CollectionNode _collectionNode;

}