/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Jorge Ferrer
 */
public class WorkflowThreadLocal {

	public static boolean isEnabled() {
		if (ExportImportThreadLocal.isImportInProcess()) {
			return false;
		}

		return _enabled.get();
	}

	public static void setEnabled(boolean enabled) {
		_enabled.set(enabled);
	}

	private static final ThreadLocal<Boolean> _enabled =
		new CentralizedThreadLocal<>(
			WorkflowThreadLocal.class + "._enabled", () -> Boolean.TRUE);

}