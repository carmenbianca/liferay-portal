/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.threadlocal;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Tina Tian
 */
public class ThreadLocalFilterThreadLocal {

	public static boolean isFilterInvoked() {
		return _filterInvoked.get();
	}

	public static void setFilterInvoked() {
		_filterInvoked.set(true);
	}

	private static final ThreadLocal<Boolean> _filterInvoked =
		new CentralizedThreadLocal<>(
			ThreadLocalFilterThreadLocal.class + "._filterInvoked",
			() -> Boolean.FALSE);

}