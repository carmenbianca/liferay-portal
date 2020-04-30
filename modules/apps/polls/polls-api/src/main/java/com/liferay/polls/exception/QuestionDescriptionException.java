/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class QuestionDescriptionException extends PortalException {

	public QuestionDescriptionException() {
	}

	public QuestionDescriptionException(String msg) {
		super(msg);
	}

	public QuestionDescriptionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public QuestionDescriptionException(Throwable cause) {
		super(cause);
	}

}