/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.convert;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alexander Chow
 */
public class ConvertException extends PortalException {

	public ConvertException() {
	}

	public ConvertException(String msg) {
		super(msg);
	}

	public ConvertException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ConvertException(Throwable cause) {
		super(cause);
	}

}