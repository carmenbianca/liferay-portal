/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchArticleImageException extends NoSuchModelException {

	public NoSuchArticleImageException() {
	}

	public NoSuchArticleImageException(String msg) {
		super(msg);
	}

	public NoSuchArticleImageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchArticleImageException(Throwable cause) {
		super(cause);
	}

}