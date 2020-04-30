/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleDisplayDateException extends PortalException {

	public ArticleDisplayDateException() {
	}

	public ArticleDisplayDateException(String msg) {
		super(msg);
	}

	public ArticleDisplayDateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ArticleDisplayDateException(Throwable cause) {
		super(cause);
	}

}