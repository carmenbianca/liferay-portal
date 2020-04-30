/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class QuestionChoiceException extends PortalException {

	public QuestionChoiceException() {
	}

	public QuestionChoiceException(String msg) {
		super(msg);
	}

	public QuestionChoiceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public QuestionChoiceException(Throwable cause) {
		super(cause);
	}

}