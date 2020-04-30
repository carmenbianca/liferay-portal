/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleSmallImageNameException extends PortalException {

	public ArticleSmallImageNameException() {
	}

	public ArticleSmallImageNameException(String msg) {
		super(msg);
	}

	public ArticleSmallImageNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ArticleSmallImageNameException(Throwable cause) {
		super(cause);
	}

}