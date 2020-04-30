/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.expression.step;

import com.liferay.petra.sql.dsl.ast.ASTNode;
import com.liferay.petra.sql.dsl.expression.Expression;

/**
 * @author Preston Crary
 */
public interface ElseEndStep<T> extends ASTNode {

	public Expression<T> elseEnd(Expression<T> expression);

	public Expression<T> elseEnd(T value);

}