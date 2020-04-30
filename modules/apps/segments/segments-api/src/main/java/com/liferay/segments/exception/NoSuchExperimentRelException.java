/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Eduardo García
 */
public class NoSuchExperimentRelException extends NoSuchModelException {

	public NoSuchExperimentRelException() {
	}

	public NoSuchExperimentRelException(String msg) {
		super(msg);
	}

	public NoSuchExperimentRelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchExperimentRelException(Throwable cause) {
		super(cause);
	}

}