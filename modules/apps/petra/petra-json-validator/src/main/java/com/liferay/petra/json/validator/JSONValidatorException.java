/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.validator;

/**
 * @author Rubén Pulido
 */
public class JSONValidatorException extends Exception {

	public JSONValidatorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public JSONValidatorException(Throwable cause) {
		super(cause);
	}

}