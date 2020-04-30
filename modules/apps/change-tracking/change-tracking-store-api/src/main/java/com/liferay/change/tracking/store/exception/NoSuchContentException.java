/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.store.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Shuyang Zhou
 */
public class NoSuchContentException extends NoSuchModelException {

	public NoSuchContentException() {
	}

	public NoSuchContentException(String msg) {
		super(msg);
	}

	public NoSuchContentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchContentException(Throwable cause) {
		super(cause);
	}

}