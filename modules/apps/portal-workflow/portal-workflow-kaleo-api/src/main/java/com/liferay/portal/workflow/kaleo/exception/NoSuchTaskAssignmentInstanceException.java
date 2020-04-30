/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTaskAssignmentInstanceException
	extends NoSuchModelException {

	public NoSuchTaskAssignmentInstanceException() {
	}

	public NoSuchTaskAssignmentInstanceException(String msg) {
		super(msg);
	}

	public NoSuchTaskAssignmentInstanceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTaskAssignmentInstanceException(Throwable cause) {
		super(cause);
	}

}