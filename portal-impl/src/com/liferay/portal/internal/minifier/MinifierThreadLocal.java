/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.internal.minifier;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.portal.util.PropsValues;

import java.io.Closeable;

/**
 * @author Shuyang Zhou
 */
public class MinifierThreadLocal {

	public static Closeable disable() {
		if (PropsValues.MINIFIER_ENABLED && _enabled.get()) {
			_enabled.set(false);

			return () -> _enabled.set(true);
		}

		return _dummy;
	}

	public static boolean isEnabled() {
		return _enabled.get();
	}

	private static final Closeable _dummy = () -> {
	};
	private static final ThreadLocal<Boolean> _enabled =
		new CentralizedThreadLocal<>(
			MinifierThreadLocal.class + "._enabled", () -> Boolean.TRUE);

}