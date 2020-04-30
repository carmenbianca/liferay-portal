/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLinkException extends NoSuchModelException {

	public NoSuchLinkException() {
	}

	public NoSuchLinkException(String msg) {
		super(msg);
	}

	public NoSuchLinkException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLinkException(Throwable cause) {
		super(cause);
	}

}