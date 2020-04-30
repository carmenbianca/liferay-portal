/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.parser;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Hugo Huijser
 */
public class ParseException extends PortalException {

	public ParseException() {
	}

	public ParseException(String msg) {
		super(msg);
	}

	public ParseException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ParseException(Throwable cause) {
		super(cause);
	}

}