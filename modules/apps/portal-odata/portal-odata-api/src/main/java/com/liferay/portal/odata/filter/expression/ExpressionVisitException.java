/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter.expression;

/**
 * Defines an exception for {@link ExpressionVisitor} to throw if an error
 * occurs while traversing the expression tree.
 *
 * @author Cristina González
 * @review
 */
public class ExpressionVisitException extends Exception {

	/**
	 * Creates a new {@code ExpressionVisitException} with a message.
	 *
	 * @param  msg the exception's message
	 * @review
	 */
	public ExpressionVisitException(String msg) {
		super(msg);
	}

	/**
	 * Creates a new {@code ExpressionVisitException} with a message and the
	 * cause of the exception.
	 *
	 * @param  msg the exception's message
	 * @param  cause the exception's cause
	 * @review
	 */
	public ExpressionVisitException(String msg, Throwable cause) {
		super(msg, cause);
	}

}