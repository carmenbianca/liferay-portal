/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Tina Tian
 */
public class SkipReplicationThreadLocal {

	public static boolean isEnabled() {
		return _skipReplicationThreadLocal.get();
	}

	public static void setEnabled(boolean enabled) {
		_skipReplicationThreadLocal.set(enabled);
	}

	private static final ThreadLocal<Boolean> _skipReplicationThreadLocal =
		new CentralizedThreadLocal<>(
			SkipReplicationThreadLocal.class + "._skipReplicationThreadLocal",
			() -> Boolean.FALSE, false);

}