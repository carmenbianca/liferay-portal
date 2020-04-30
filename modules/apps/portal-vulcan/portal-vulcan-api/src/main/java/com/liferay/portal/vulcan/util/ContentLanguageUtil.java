/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.util;

import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.Locale;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.HttpHeaders;

/**
 * @author Víctor Galán
 */
public class ContentLanguageUtil {

	public static void addContentLanguageHeader(
		String[] availableLocaleIds, String defaultLocaleId,
		HttpServletResponse httpServletResponse, Locale requestedLocale) {

		Locale contentLocale = Stream.of(
			availableLocaleIds
		).map(
			LocaleUtil::fromLanguageId
		).filter(
			locale -> LocaleUtil.equals(locale, requestedLocale)
		).findFirst(
		).orElse(
			LocaleUtil.fromLanguageId(defaultLocaleId)
		);

		httpServletResponse.addHeader(
			HttpHeaders.CONTENT_LANGUAGE,
			LocaleUtil.toW3cLanguageId(contentLocale));
	}

}