/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutBranchException extends NoSuchModelException {

	public NoSuchLayoutBranchException() {
	}

	public NoSuchLayoutBranchException(String msg) {
		super(msg);
	}

	public NoSuchLayoutBranchException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutBranchException(Throwable cause) {
		super(cause);
	}

}