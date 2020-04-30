/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.access.control;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Michael C. Han
 * @author Raymond Augé
 */
public class AccessControlThreadLocal {

	public static boolean isRemoteAccess() {
		return _remoteAccess.get();
	}

	public static void setRemoteAccess(boolean remoteAccess) {
		_remoteAccess.set(remoteAccess);
	}

	private static final ThreadLocal<Boolean> _remoteAccess =
		new CentralizedThreadLocal<>(
			AccessControlThreadLocal.class + "._remoteAccess",
			() -> Boolean.FALSE);

}