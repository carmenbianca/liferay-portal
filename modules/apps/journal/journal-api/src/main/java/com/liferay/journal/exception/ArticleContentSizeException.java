/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 * @author Vilmos Papp
 */
public class ArticleContentSizeException extends PortalException {

	public ArticleContentSizeException() {
	}

	public ArticleContentSizeException(String msg) {
		super(msg);
	}

	public ArticleContentSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ArticleContentSizeException(Throwable cause) {
		super(cause);
	}

}