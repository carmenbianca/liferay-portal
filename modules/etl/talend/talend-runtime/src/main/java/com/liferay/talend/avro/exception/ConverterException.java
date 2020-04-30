/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.avro.exception;

import com.liferay.talend.exception.BaseComponentException;

/**
 * @author Igor Beslic
 */
public class ConverterException extends BaseComponentException {

	public ConverterException(String message) {
		super(message, 0);
	}

	public ConverterException(String message, Throwable cause) {
		super(message, 0, cause);
	}

}