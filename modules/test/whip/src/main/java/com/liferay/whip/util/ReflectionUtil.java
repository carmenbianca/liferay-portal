/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.whip.util;

/**
 * @author Shuyang Zhou
 */
public class ReflectionUtil {

	public static <T> T throwException(Throwable throwable) {
		return ReflectionUtil.<T, RuntimeException>_throwException(throwable);
	}

	@SuppressWarnings("unchecked")
	private static <T, E extends Throwable> T _throwException(
			Throwable throwable)
		throws E {

		throw (E)throwable;
	}

}