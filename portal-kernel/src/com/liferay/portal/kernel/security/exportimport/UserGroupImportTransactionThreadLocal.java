/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.exportimport;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Brian Wing Shun Chan
 */
public class UserGroupImportTransactionThreadLocal {

	public static boolean isOriginatesFromImport() {
		return _originatesFromImport.get();
	}

	public static void setOriginatesFromImport(boolean originatesFromImport) {
		_originatesFromImport.set(originatesFromImport);
	}

	private static final ThreadLocal<Boolean> _originatesFromImport =
		new CentralizedThreadLocal<>(
			UserGroupImportTransactionThreadLocal.class +
				"._originatesFromImport",
			() -> Boolean.FALSE, false);

}