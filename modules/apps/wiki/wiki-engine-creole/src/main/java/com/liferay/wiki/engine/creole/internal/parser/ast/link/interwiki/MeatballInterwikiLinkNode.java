/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.internal.parser.ast.link.interwiki;

import com.liferay.wiki.engine.creole.internal.parser.visitor.ASTVisitor;

/**
 * @author Miguel Pastor
 */
public class MeatballInterwikiLinkNode extends InterwikiLinkNode {

	@Override
	public void accept(ASTVisitor astVisitor) {
		astVisitor.visit(this);
	}

	@Override
	public String getBaseURL() {
		return "http://usemod.com/cgi-bin/mb.pl?";
	}

}