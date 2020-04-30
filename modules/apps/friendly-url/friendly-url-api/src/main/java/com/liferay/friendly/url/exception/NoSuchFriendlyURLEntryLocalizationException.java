/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.friendly.url.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFriendlyURLEntryLocalizationException
	extends NoSuchModelException {

	public NoSuchFriendlyURLEntryLocalizationException() {
	}

	public NoSuchFriendlyURLEntryLocalizationException(String msg) {
		super(msg);
	}

	public NoSuchFriendlyURLEntryLocalizationException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public NoSuchFriendlyURLEntryLocalizationException(Throwable cause) {
		super(cause);
	}

}