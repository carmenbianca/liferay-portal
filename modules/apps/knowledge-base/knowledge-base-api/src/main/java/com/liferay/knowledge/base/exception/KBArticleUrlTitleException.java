/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.exception;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class KBArticleUrlTitleException extends PortalException {

	public KBArticleUrlTitleException() {
	}

	public KBArticleUrlTitleException(String msg) {
		super(msg);
	}

	public KBArticleUrlTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public KBArticleUrlTitleException(Throwable cause) {
		super(cause);
	}

	public static class MustNotBeDuplicate extends KBArticleUrlTitleException {

		public MustNotBeDuplicate(String urlTitle) {
			super("Duplicate URL title " + urlTitle);
		}

	}

	public static class MustNotContainInvalidCharacters
		extends KBArticleUrlTitleException {

		public MustNotContainInvalidCharacters(String urlTitle) {
			super(
				StringBundler.concat(
					"URL title ", urlTitle, " must start with a '/' and ",
					"contain only alphanumeric characters, dashes, and ",
					"underscores"));
		}

	}

	public static class MustNotExceedMaximumSize
		extends KBArticleUrlTitleException {

		public MustNotExceedMaximumSize(String urlTitle, int urlTitleMaxSize) {
			super(
				StringBundler.concat(
					"URL title ", urlTitle, " must have fewer than ",
					urlTitleMaxSize, " characters"));
		}

	}

}