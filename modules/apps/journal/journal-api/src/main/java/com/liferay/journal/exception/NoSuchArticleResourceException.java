/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchArticleResourceException extends NoSuchModelException {

	public NoSuchArticleResourceException() {
	}

	public NoSuchArticleResourceException(String msg) {
		super(msg);
	}

	public NoSuchArticleResourceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchArticleResourceException(Throwable cause) {
		super(cause);
	}

}