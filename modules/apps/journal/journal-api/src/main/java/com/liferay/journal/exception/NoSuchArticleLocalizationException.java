/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchArticleLocalizationException extends NoSuchModelException {

	public NoSuchArticleLocalizationException() {
	}

	public NoSuchArticleLocalizationException(String msg) {
		super(msg);
	}

	public NoSuchArticleLocalizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchArticleLocalizationException(Throwable cause) {
		super(cause);
	}

}