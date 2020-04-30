/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.async.advice.internal;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Shuyang Zhou
 */
public class AsyncInvokeThreadLocal {

	public static boolean isEnabled() {
		return _enabled.get();
	}

	public static void setEnabled(boolean enabled) {
		_enabled.set(enabled);
	}

	private static final ThreadLocal<Boolean> _enabled =
		new CentralizedThreadLocal<>(
			AsyncInvokeThreadLocal.class + "._enabled", () -> Boolean.FALSE);

}