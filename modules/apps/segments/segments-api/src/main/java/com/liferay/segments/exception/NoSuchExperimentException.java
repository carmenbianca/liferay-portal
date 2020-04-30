/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Eduardo García
 */
public class NoSuchExperimentException extends NoSuchModelException {

	public NoSuchExperimentException() {
	}

	public NoSuchExperimentException(String msg) {
		super(msg);
	}

	public NoSuchExperimentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchExperimentException(Throwable cause) {
		super(cause);
	}

}