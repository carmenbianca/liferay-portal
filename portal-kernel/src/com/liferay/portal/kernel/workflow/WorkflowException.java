/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Micha Kiener
 * @author Brian Wing Shun Chan
 */
public class WorkflowException extends PortalException {

	public WorkflowException() {
	}

	public WorkflowException(String msg) {
		super(msg);
	}

	public WorkflowException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WorkflowException(Throwable cause) {
		super(cause);
	}

}