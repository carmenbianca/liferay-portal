/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.query;

import com.liferay.petra.sql.dsl.ast.ASTNodeListener;
import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.petra.sql.dsl.query.HavingStep;
import com.liferay.petra.sql.dsl.spi.ast.BaseASTNode;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Preston Crary
 */
public class Having extends BaseASTNode implements DefaultOrderByStep {

	public Having(HavingStep havingStep, Predicate predicate) {
		super(havingStep);

		_predicate = Objects.requireNonNull(predicate);
	}

	public Predicate getPredicate() {
		return _predicate;
	}

	@Override
	protected void doToSQL(
		Consumer<String> consumer, ASTNodeListener astNodeListener) {

		consumer.accept("having ");

		_predicate.toSQL(consumer, astNodeListener);
	}

	private final Predicate _predicate;

}