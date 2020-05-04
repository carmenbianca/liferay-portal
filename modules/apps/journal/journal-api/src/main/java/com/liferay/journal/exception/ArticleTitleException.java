/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleTitleException extends PortalException {

	public ArticleTitleException() {
	}

	public ArticleTitleException(String msg) {
		super(msg);
	}

	public ArticleTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ArticleTitleException(Throwable cause) {
		super(cause);
	}

	public static class MustNotExceedMaximumLength
		extends ArticleTitleException {

		public MustNotExceedMaximumLength(String title, int titleMaxLength) {
			super(
				StringBundler.concat(
					"Title ", title, " must have fewer than ", titleMaxLength,
					" characters"));
		}

	}

}