/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

/**
 * @author Miguel Pastor
 */
public abstract class BaseListNode extends BaseParentableNode {

	public BaseListNode() {
	}

	public BaseListNode(
		BaseParentableNode baseParentableNode, CollectionNode collectionNode) {

		super(collectionNode);

		_baseParentableNode = baseParentableNode;
	}

	public BaseListNode(int token) {
		super(token);
	}

	public BaseParentableNode getBaseParentableNode() {
		return _baseParentableNode;
	}

	public void setParent(BaseParentableNode baseParentableNode) {
		_baseParentableNode = baseParentableNode;
	}

	private BaseParentableNode _baseParentableNode;

}