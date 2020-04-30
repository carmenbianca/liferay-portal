/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.antlrwiki.translator.internal;

import com.liferay.wiki.engine.creole.internal.parser.ast.HeadingNode;

/**
 * @author Miguel Pastor
 */
public class UnformattedHeadingTextVisitor extends UnformattedTextVisitor {

	public String getUnformattedText(HeadingNode headingNode) {
		traverse(headingNode.getChildASTNodes());

		return getText();
	}

}