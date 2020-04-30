/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchGadgetException extends NoSuchModelException {

	public NoSuchGadgetException() {
	}

	public NoSuchGadgetException(String msg) {
		super(msg);
	}

	public NoSuchGadgetException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchGadgetException(Throwable cause) {
		super(cause);
	}

}