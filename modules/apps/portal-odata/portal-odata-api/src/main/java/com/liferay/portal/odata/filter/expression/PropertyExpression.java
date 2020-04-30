/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter.expression;

/**
 * Models a property {@code Expression}.
 *
 * @author Rubén Pulido
 * @review
 */
public interface PropertyExpression extends Expression {

	/**
	 * Gets the property expression name.
	 *
	 * @return the name
	 */
	public String getName();

}