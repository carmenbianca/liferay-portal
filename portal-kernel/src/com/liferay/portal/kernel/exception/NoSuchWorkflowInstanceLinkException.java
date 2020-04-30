/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchWorkflowInstanceLinkException extends NoSuchModelException {

	public NoSuchWorkflowInstanceLinkException() {
	}

	public NoSuchWorkflowInstanceLinkException(String msg) {
		super(msg);
	}

	public NoSuchWorkflowInstanceLinkException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchWorkflowInstanceLinkException(Throwable cause) {
		super(cause);
	}

}