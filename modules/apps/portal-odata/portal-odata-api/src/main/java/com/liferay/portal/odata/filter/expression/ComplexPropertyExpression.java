/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter.expression;

/**
 * Models a complex {@code PropertyExpression}.
 *
 * @author Rubén Pulido
 * @review
 */
public interface ComplexPropertyExpression extends PropertyExpression {

	/**
	 * Gets the primitive property expression.
	 *
	 * @return the primitive property expression
	 */
	public PropertyExpression getPropertyExpression();

}