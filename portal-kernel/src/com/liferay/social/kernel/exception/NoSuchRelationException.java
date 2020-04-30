/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRelationException extends NoSuchModelException {

	public NoSuchRelationException() {
	}

	public NoSuchRelationException(String msg) {
		super(msg);
	}

	public NoSuchRelationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRelationException(Throwable cause) {
		super(cause);
	}

}