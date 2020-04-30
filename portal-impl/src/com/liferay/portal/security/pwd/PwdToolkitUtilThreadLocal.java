/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.pwd;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Brian Wing Shun Chan
 */
public class PwdToolkitUtilThreadLocal {

	public static boolean isValidate() {
		return _validate.get();
	}

	public static void setValidate(boolean validate) {
		_validate.set(validate);
	}

	private static final ThreadLocal<Boolean> _validate =
		new CentralizedThreadLocal<>(
			PwdToolkitUtilThreadLocal.class + "._validate", () -> Boolean.TRUE,
			false);

}