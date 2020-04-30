/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.util;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Mika Koivisto
 */
public class DLProcessorThreadLocal {

	public static boolean isEnabled() {
		return _enabled.get();
	}

	public static void setEnabled(boolean enabled) {
		_enabled.set(enabled);
	}

	private static final ThreadLocal<Boolean> _enabled =
		new CentralizedThreadLocal<>(
			DLProcessorThreadLocal.class + "._enabled", () -> Boolean.TRUE);

}