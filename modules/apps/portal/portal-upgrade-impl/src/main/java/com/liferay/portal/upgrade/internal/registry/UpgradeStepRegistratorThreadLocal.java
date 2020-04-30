/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.internal.registry;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.petra.lang.SafeClosable;

/**
 * @author Preston Crary
 */
public class UpgradeStepRegistratorThreadLocal {

	public static boolean isEnabled() {
		return _enabled.get();
	}

	public static SafeClosable setEnabled(boolean enabled) {
		return _enabled.setWithSafeClosable(enabled);
	}

	private static final CentralizedThreadLocal<Boolean> _enabled =
		new CentralizedThreadLocal<>(
			UpgradeStepRegistratorThreadLocal.class + "._enabled",
			() -> Boolean.TRUE);

}