/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lifecycle;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

import java.io.Serializable;

/**
 * @author Michael C. Han
 */
public class ExportImportLifecycleManagerUtil {

	public static void fireExportImportLifecycleEvent(
		int code, int processFlag, String processId,
		Serializable... arguments) {

		_exportImportLifecycleManager.fireExportImportLifecycleEvent(
			code, processFlag, processId, arguments);
	}

	private static volatile ExportImportLifecycleManager
		_exportImportLifecycleManager =
			ServiceProxyFactory.newServiceTrackedInstance(
				ExportImportLifecycleManager.class,
				ExportImportLifecycleManagerUtil.class,
				"_exportImportLifecycleManager", false);

}