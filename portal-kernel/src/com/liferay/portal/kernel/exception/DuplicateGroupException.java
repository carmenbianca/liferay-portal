/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateGroupException extends PortalException {

	public DuplicateGroupException() {
	}

	public DuplicateGroupException(String msg) {
		super(msg);
	}

	public DuplicateGroupException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateGroupException(Throwable cause) {
		super(cause);
	}

}