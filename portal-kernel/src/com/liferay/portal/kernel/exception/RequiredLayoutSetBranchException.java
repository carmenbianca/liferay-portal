/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredLayoutSetBranchException extends PortalException {

	public RequiredLayoutSetBranchException() {
	}

	public RequiredLayoutSetBranchException(String msg) {
		super(msg);
	}

	public RequiredLayoutSetBranchException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredLayoutSetBranchException(Throwable cause) {
		super(cause);
	}

}