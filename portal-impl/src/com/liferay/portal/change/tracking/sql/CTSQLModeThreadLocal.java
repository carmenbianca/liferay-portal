/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.change.tracking.sql;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.petra.lang.SafeClosable;

/**
 * @author Preston Crary
 */
public class CTSQLModeThreadLocal {

	public static CTSQLMode getCTSQLMode() {
		return _ctSQLMode.get();
	}

	public static SafeClosable setCTSQLMode(CTSQLMode ctSQLMode) {
		return _ctSQLMode.setWithSafeClosable(ctSQLMode);
	}

	public static enum CTSQLMode {

		CT_ONLY, DEFAULT,

	}

	private CTSQLModeThreadLocal() {
	}

	private static final CentralizedThreadLocal<CTSQLMode> _ctSQLMode =
		new CentralizedThreadLocal<>(
			CTSQLModeThreadLocal.class + "._ctSQLMode",
			() -> CTSQLMode.DEFAULT);

}