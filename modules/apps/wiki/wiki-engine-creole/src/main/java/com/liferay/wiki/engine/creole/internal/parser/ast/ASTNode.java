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
public abstract class ASTNode {

	public ASTNode() {
	}

	public ASTNode(int tokenType) {
		this(new CommonToken(tokenType));
	}

	public ASTNode(Token token) {
		_token = token;
	}

	public abstract void accept(ASTVisitor astVisitor);

	public Token getToken() {
		return _token;
	}

	public void setToken(Token token) {
		_token = token;
	}

	private Token _token;

}