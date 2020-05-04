/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Sergio González
 */
public class LocalizedException extends PortalException {

	public LocalizedException() {
	}

	public LocalizedException(String msg) {
		super(msg);
	}

	public LocalizedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LocalizedException(Throwable cause) {
		super(cause);
	}

	public void addLocalizedException(Locale locale, Exception exception) {
		_localizedExceptionsMap.put(locale, exception);
	}

	public Map<Locale, Exception> getLocalizedExceptionsMap() {
		return _localizedExceptionsMap;
	}

	private final Map<Locale, Exception> _localizedExceptionsMap =
		new HashMap<>();

}