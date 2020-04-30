/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Eduardo García
 */
public class NoSuchExperienceException extends NoSuchModelException {

	public NoSuchExperienceException() {
	}

	public NoSuchExperienceException(String msg) {
		super(msg);
	}

	public NoSuchExperienceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchExperienceException(Throwable cause) {
		super(cause);
	}

}