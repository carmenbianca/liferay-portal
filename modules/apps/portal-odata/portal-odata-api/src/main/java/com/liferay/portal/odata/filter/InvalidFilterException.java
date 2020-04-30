/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter;

import javax.ws.rs.BadRequestException;

/**
 * Models errors that occur when handling {@link Filter} objects.
 *
 * @author David Arques
 * @review
 */
public class InvalidFilterException extends BadRequestException {

	/**
	 * Creates a new {@code InvalidFilterException} with a message.
	 *
	 * @param  msg the message
	 * @review
	 */
	public InvalidFilterException(String msg) {
		super(msg);
	}

	/**
	 * Creates a new {@code InvalidFilterException} with a message and the cause
	 * of the exception.
	 *
	 * @param  msg the message
	 * @param  cause the cause
	 * @review
	 */
	public InvalidFilterException(String msg, Throwable cause) {
		super(msg, cause);
	}

}