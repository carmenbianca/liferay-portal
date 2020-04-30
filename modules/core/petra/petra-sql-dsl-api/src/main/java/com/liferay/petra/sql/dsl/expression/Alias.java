/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.expression;

/**
 * @author Preston Crary
 */
public interface Alias<T> extends Expression<T> {

	public Expression<T> getExpression();

	public String getName();

}