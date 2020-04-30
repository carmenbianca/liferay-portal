/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.sort;

import javax.ws.rs.BadRequestException;

/**
 * Models {@link Sort} errors.
 *
 * @author Cristina González
 * @review
 */
public class InvalidSortException extends BadRequestException {

	/**
	 * Creates a new {@code InvalidSortException} with the provided message.
	 *
	 * @param  msg the message
	 * @review
	 */
	public InvalidSortException(String msg) {
		super(msg);
	}

	/**
	 * Creates a new {@code InvalidSortException} with the provided message and
	 * cause.
	 *
	 * @param  msg the message
	 * @param  cause the cause
	 * @review
	 */
	public InvalidSortException(String msg, Throwable cause) {
		super(msg, cause);
	}

}