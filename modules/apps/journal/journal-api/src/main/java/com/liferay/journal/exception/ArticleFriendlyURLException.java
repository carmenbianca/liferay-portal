/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleFriendlyURLException extends PortalException {

	public ArticleFriendlyURLException() {
	}

	public ArticleFriendlyURLException(String msg) {
		super(msg);
	}

	public ArticleFriendlyURLException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ArticleFriendlyURLException(Throwable cause) {
		super(cause);
	}

}