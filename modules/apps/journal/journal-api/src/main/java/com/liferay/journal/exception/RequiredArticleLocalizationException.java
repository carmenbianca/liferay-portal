/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author José Ángel Jiménez Campoy
 */
public class RequiredArticleLocalizationException extends PortalException {

	public RequiredArticleLocalizationException() {
	}

	public RequiredArticleLocalizationException(String msg) {
		super(msg);
	}

	public RequiredArticleLocalizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredArticleLocalizationException(Throwable cause) {
		super(cause);
	}

}