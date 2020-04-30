/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRecentLayoutSetBranchException extends NoSuchModelException {

	public NoSuchRecentLayoutSetBranchException() {
	}

	public NoSuchRecentLayoutSetBranchException(String msg) {
		super(msg);
	}

	public NoSuchRecentLayoutSetBranchException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRecentLayoutSetBranchException(Throwable cause) {
		super(cause);
	}

}