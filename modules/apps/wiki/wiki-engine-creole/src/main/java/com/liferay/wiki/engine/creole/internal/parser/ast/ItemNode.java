/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast;

/**
 * @author Miguel Pastor
 */
public abstract class ItemNode extends BaseParentableNode {

	public ItemNode(int tokenType) {
		this(tokenType, 0, null, null);
	}

	public ItemNode(
		int level, BaseParentableNode baseParentableNode,
		CollectionNode collectionNode) {

		this(0, level, baseParentableNode, collectionNode);
	}

	public BaseParentableNode getBaseParentableNode() {
		return _baseParentableNode;
	}

	public int getLevel() {
		return _level;
	}

	public void setBaseParentableNode(BaseParentableNode baseParentableNode) {
		_baseParentableNode = baseParentableNode;
	}

	protected ItemNode(
		int tokenType, int level, BaseParentableNode baseParentableNode,
		CollectionNode collectionNode) {

		super(collectionNode, tokenType);

		_level = level;
		_baseParentableNode = baseParentableNode;
	}

	private BaseParentableNode _baseParentableNode;
	private final int _level;

}