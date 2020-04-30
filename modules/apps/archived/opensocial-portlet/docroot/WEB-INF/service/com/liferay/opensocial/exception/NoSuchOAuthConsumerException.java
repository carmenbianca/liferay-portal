/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchOAuthConsumerException extends NoSuchModelException {

	public NoSuchOAuthConsumerException() {
	}

	public NoSuchOAuthConsumerException(String msg) {
		super(msg);
	}

	public NoSuchOAuthConsumerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchOAuthConsumerException(Throwable cause) {
		super(cause);
	}

}