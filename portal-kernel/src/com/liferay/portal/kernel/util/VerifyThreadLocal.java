/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Preston Crary
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public class VerifyThreadLocal {

	public static boolean isVerifyInProgress() {
		return _verifyInProgress.get();
	}

	public static void setVerifyInProgress(boolean enabled) {
		_verifyInProgress.set(enabled);
	}

	private static final ThreadLocal<Boolean> _verifyInProgress =
		new CentralizedThreadLocal<>(
			VerifyThreadLocal.class + "._verifyInProgress",
			() -> Boolean.FALSE);

}