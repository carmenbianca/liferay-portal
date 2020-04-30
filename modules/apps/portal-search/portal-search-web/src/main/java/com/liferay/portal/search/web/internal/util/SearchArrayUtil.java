/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.util;

import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.Optional;

/**
 * @author André de Oliveira
 */
public class SearchArrayUtil {

	public static Optional<String[]> maybe(String[] texts) {
		if (ArrayUtil.isEmpty(texts)) {
			return Optional.empty();
		}

		return Optional.of(texts);
	}

}