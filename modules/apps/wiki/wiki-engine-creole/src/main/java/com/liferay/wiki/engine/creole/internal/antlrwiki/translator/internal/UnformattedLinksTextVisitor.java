/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.antlrwiki.translator.internal;

import com.liferay.wiki.engine.creole.internal.parser.ast.CollectionNode;
import com.liferay.wiki.engine.creole.internal.parser.ast.link.LinkNode;

/**
 * @author Miguel Pastor
 */
public class UnformattedLinksTextVisitor extends UnformattedTextVisitor {

	public String getUnformattedText(LinkNode linkNode) {
		CollectionNode altCollectionNode = linkNode.getAltCollectionNode();

		traverse(altCollectionNode.getASTNodes());

		return getText();
	}

}