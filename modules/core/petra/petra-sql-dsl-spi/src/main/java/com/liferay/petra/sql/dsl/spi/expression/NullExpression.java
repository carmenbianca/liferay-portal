/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.expression;

import com.liferay.petra.sql.dsl.ast.ASTNodeListener;
import com.liferay.petra.sql.dsl.spi.ast.BaseASTNode;

import java.util.function.Consumer;

/**
 * @author Preston Crary
 */
public class NullExpression
	extends BaseASTNode implements DefaultExpression<Void> {

	public static final NullExpression INSTANCE = new NullExpression();

	@Override
	protected void doToSQL(
		Consumer<String> consumer, ASTNodeListener astNodeListener) {

		consumer.accept("NULL");
	}

	private NullExpression() {
	}

}