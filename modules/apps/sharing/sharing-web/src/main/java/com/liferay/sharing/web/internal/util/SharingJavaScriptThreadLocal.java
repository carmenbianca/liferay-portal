/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.web.internal.util;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Alejandro Tardín
 */
public class SharingJavaScriptThreadLocal {

	public static boolean isSharingJavaScriptNeeded() {
		return _sharingJavaScriptNeeded.get();
	}

	public static void setSharingJavaScriptNeeded(
		boolean sharingJavaScriptNeeded) {

		_sharingJavaScriptNeeded.set(sharingJavaScriptNeeded);
	}

	private static final ThreadLocal<Boolean> _sharingJavaScriptNeeded =
		new CentralizedThreadLocal<>(
			SharingJavaScriptThreadLocal.class + "._sharingJavaScriptNeeded",
			() -> Boolean.FALSE, false);

}