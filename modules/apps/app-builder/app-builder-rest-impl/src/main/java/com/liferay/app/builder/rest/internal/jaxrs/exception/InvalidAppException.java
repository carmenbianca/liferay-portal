/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.rest.internal.jaxrs.exception;

/**
 * @author Bruno Farache
 */
public class InvalidAppException extends Exception {

	public InvalidAppException(String msg) {
		super(msg);
	}

}