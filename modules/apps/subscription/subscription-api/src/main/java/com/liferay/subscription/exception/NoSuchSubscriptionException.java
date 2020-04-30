/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.subscription.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSubscriptionException extends NoSuchModelException {

	public NoSuchSubscriptionException() {
	}

	public NoSuchSubscriptionException(String msg) {
		super(msg);
	}

	public NoSuchSubscriptionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSubscriptionException(Throwable cause) {
		super(cause);
	}

}