/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleVersionException extends PortalException {

	public ArticleVersionException() {
	}

	public ArticleVersionException(String msg) {
		super(msg);
	}

	public ArticleVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ArticleVersionException(Throwable cause) {
		super(cause);
	}

}