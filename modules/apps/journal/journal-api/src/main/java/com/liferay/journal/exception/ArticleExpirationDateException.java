/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleExpirationDateException extends PortalException {

	public ArticleExpirationDateException() {
	}

	public ArticleExpirationDateException(String msg) {
		super(msg);
	}

	public ArticleExpirationDateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ArticleExpirationDateException(Throwable cause) {
		super(cause);
	}

}