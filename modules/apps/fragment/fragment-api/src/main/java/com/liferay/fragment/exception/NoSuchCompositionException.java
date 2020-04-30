/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCompositionException extends NoSuchModelException {

	public NoSuchCompositionException() {
	}

	public NoSuchCompositionException(String msg) {
		super(msg);
	}

	public NoSuchCompositionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCompositionException(Throwable cause) {
		super(cause);
	}

}