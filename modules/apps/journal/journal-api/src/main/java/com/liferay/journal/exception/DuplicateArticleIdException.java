/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateArticleIdException extends PortalException {

	public DuplicateArticleIdException() {
	}

	public DuplicateArticleIdException(String msg) {
		super(msg);
	}

	public DuplicateArticleIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateArticleIdException(Throwable cause) {
		super(cause);
	}

}