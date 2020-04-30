/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryImageNameException extends PortalException {

	public EntryImageNameException() {
	}

	public EntryImageNameException(String msg) {
		super(msg);
	}

	public EntryImageNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryImageNameException(Throwable cause) {
		super(cause);
	}

}