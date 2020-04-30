/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class QuestionTitleException extends PortalException {

	public QuestionTitleException() {
	}

	public QuestionTitleException(String msg) {
		super(msg);
	}

	public QuestionTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public QuestionTitleException(Throwable cause) {
		super(cause);
	}

}