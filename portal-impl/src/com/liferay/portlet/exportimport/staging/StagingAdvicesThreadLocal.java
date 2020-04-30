/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.exportimport.staging;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Raymond Augé
 */
public class StagingAdvicesThreadLocal {

	public static boolean isEnabled() {
		return _enabled.get();
	}

	public static void setEnabled(boolean enabled) {
		_enabled.set(enabled);
	}

	private static final ThreadLocal<Boolean> _enabled =
		new CentralizedThreadLocal<>(
			StagingAdvicesThreadLocal.class + "._enabled", () -> Boolean.TRUE);

}