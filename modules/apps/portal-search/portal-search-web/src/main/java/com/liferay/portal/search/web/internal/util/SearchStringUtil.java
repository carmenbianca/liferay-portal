/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.util;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author André de Oliveira
 */
public class SearchStringUtil {

	public static Optional<String> maybe(String s) {
		s = StringUtil.trim(s);

		if (Validator.isBlank(s)) {
			return Optional.empty();
		}

		return Optional.of(s);
	}

	public static String[] splitAndUnquote(Optional<String> optional) {
		return Optional.ofNullable(
			optional
		).orElse(
			Optional.empty()
		).map(
			SearchStringUtil::splitAndUnquote
		).orElse(
			new String[0]
		);
	}

	public static String[] splitAndUnquote(String s) {
		return Stream.of(
			StringUtil.split(s.trim(), CharPool.COMMA)
		).map(
			String::trim
		).map(
			StringUtil::unquote
		).toArray(
			String[]::new
		);
	}

}