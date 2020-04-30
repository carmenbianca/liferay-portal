/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Tina Tian
 */
public class PluginContextLifecycleThreadLocal {

	public static boolean isDestroying() {
		return _destroying.get();
	}

	public static boolean isInitializing() {
		return _initializing.get();
	}

	public static void setDestroying(boolean destroying) {
		_destroying.set(destroying);
	}

	public static void setInitializing(boolean initializing) {
		_initializing.set(initializing);
	}

	private static final ThreadLocal<Boolean> _destroying =
		new CentralizedThreadLocal<>(
			PluginContextLifecycleThreadLocal.class + "._destroying",
			() -> Boolean.FALSE, false);
	private static final ThreadLocal<Boolean> _initializing =
		new CentralizedThreadLocal<>(
			PluginContextLifecycleThreadLocal.class + "._initializing",
			() -> Boolean.FALSE, false);

}