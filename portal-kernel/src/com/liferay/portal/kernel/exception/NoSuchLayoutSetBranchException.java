/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutSetBranchException extends NoSuchModelException {

	public NoSuchLayoutSetBranchException() {
	}

	public NoSuchLayoutSetBranchException(String msg) {
		super(msg);
	}

	public NoSuchLayoutSetBranchException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutSetBranchException(Throwable cause) {
		super(cause);
	}

}