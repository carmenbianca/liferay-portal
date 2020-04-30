/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateNodeNameException extends PortalException {

	public DuplicateNodeNameException() {
	}

	public DuplicateNodeNameException(String msg) {
		super(msg);
	}

	public DuplicateNodeNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateNodeNameException(Throwable cause) {
		super(cause);
	}

}