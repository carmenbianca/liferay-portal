/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAutoResolutionInfoException extends NoSuchModelException {

	public NoSuchAutoResolutionInfoException() {
	}

	public NoSuchAutoResolutionInfoException(String msg) {
		super(msg);
	}

	public NoSuchAutoResolutionInfoException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAutoResolutionInfoException(Throwable cause) {
		super(cause);
	}

}