/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.velocity.internal;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Tina Tian
 */
public class RestrictedTemplateThreadLocal {

	public static boolean isRestricted() {
		return _restricted.get();
	}

	public static void setRestricted(boolean restricted) {
		_restricted.set(restricted);
	}

	private static final ThreadLocal<Boolean> _restricted =
		new CentralizedThreadLocal<>(
			RestrictedTemplateThreadLocal.class + "._restricted",
			() -> Boolean.FALSE);

}