/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleSmallImageSizeException extends PortalException {

	public ArticleSmallImageSizeException() {
	}

	public ArticleSmallImageSizeException(String msg) {
		super(msg);
	}

	public ArticleSmallImageSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ArticleSmallImageSizeException(Throwable cause) {
		super(cause);
	}

}