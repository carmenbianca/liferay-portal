/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging.proxy;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.petra.lang.SafeClosable;

/**
 * @author Shuyang Zhou
 */
public class ProxyModeThreadLocal {

	public static boolean isForceSync() {
		return _forceSync.get();
	}

	/**
	 * @deprecated As of Mueller (7.2.x), replaced by {@link
	 *             #setWithSafeClosable(boolean)}
	 */
	@Deprecated
	public static void setForceSync(boolean forceSync) {
		_forceSync.set(forceSync);
	}

	public static SafeClosable setWithSafeClosable(boolean forceSync) {
		return _forceSync.setWithSafeClosable(forceSync);
	}

	private static final CentralizedThreadLocal<Boolean> _forceSync =
		new CentralizedThreadLocal<>(
			ProxyModeThreadLocal.class + "_forceSync", () -> Boolean.FALSE);

}