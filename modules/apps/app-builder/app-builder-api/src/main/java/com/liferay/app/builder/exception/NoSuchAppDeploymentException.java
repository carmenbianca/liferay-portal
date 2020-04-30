/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAppDeploymentException extends NoSuchModelException {

	public NoSuchAppDeploymentException() {
	}

	public NoSuchAppDeploymentException(String msg) {
		super(msg);
	}

	public NoSuchAppDeploymentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAppDeploymentException(Throwable cause) {
		super(cause);
	}

}