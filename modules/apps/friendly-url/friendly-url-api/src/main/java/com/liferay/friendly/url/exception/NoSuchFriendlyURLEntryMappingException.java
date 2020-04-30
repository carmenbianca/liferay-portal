/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.friendly.url.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFriendlyURLEntryMappingException
	extends NoSuchModelException {

	public NoSuchFriendlyURLEntryMappingException() {
	}

	public NoSuchFriendlyURLEntryMappingException(String msg) {
		super(msg);
	}

	public NoSuchFriendlyURLEntryMappingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFriendlyURLEntryMappingException(Throwable cause) {
		super(cause);
	}

}