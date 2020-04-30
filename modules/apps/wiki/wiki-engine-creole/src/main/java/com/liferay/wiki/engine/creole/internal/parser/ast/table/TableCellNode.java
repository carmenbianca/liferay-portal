/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast.table;

import com.liferay.wiki.engine.creole.internal.parser.ast.BaseParentableNode;
import com.liferay.wiki.engine.creole.internal.parser.ast.CollectionNode;

/**
 * @author Miguel Pastor
 */
public abstract class TableCellNode extends BaseParentableNode {

	public TableCellNode() {
	}

	public TableCellNode(CollectionNode collectionNode) {
		super(collectionNode);
	}

	public TableCellNode(int tokenType) {
		super(tokenType);
	}

}