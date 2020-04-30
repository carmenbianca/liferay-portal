/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchQuestionException extends NoSuchModelException {

	public NoSuchQuestionException() {
	}

	public NoSuchQuestionException(String msg) {
		super(msg);
	}

	public NoSuchQuestionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchQuestionException(Throwable cause) {
		super(cause);
	}

}