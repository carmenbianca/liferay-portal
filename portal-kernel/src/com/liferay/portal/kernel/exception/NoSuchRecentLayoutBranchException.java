/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRecentLayoutBranchException extends NoSuchModelException {

	public NoSuchRecentLayoutBranchException() {
	}

	public NoSuchRecentLayoutBranchException(String msg) {
		super(msg);
	}

	public NoSuchRecentLayoutBranchException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRecentLayoutBranchException(Throwable cause) {
		super(cause);
	}

}