/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.visitor;

import com.liferay.wiki.engine.creole.internal.parser.ast.link.LinkNode;

/**
 * @author Miguel Pastor
 */
public class LinkNodeCollectorVisitor extends NodeCollectorVisitor {

	@Override
	public void visit(LinkNode linkNode) {
		addNode(linkNode);
	}

}