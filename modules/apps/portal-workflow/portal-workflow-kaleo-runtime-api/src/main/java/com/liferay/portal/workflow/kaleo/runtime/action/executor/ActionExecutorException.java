/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.action.executor;

import com.liferay.portal.kernel.workflow.WorkflowException;

/**
 * @author Michael C. Han
 */
public class ActionExecutorException extends WorkflowException {

	public ActionExecutorException() {
	}

	public ActionExecutorException(String msg) {
		super(msg);
	}

	public ActionExecutorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ActionExecutorException(Throwable cause) {
		super(cause);
	}

}