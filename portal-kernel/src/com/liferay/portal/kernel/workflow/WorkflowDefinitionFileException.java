/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

/**
 * @author Marcellus Tavares
 */
public class WorkflowDefinitionFileException extends WorkflowException {

	public WorkflowDefinitionFileException() {
	}

	public WorkflowDefinitionFileException(String msg) {
		super(msg);
	}

	public WorkflowDefinitionFileException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WorkflowDefinitionFileException(Throwable cause) {
		super(cause);
	}

}