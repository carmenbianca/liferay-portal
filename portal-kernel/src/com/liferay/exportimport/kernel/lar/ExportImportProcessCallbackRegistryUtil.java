/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lar;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

import java.util.concurrent.Callable;

/**
 * @author Daniel Kocsis
 */
public class ExportImportProcessCallbackRegistryUtil {

	public static void registerCallback(
		String processId, Callable<?> callable) {

		_exportImportProcessCommitCallbackRegistry.registerCallback(
			processId, callable);
	}

	private static volatile ExportImportProcessCallbackRegistry
		_exportImportProcessCommitCallbackRegistry =
			ServiceProxyFactory.newServiceTrackedInstance(
				ExportImportProcessCallbackRegistry.class,
				ExportImportProcessCallbackRegistryUtil.class,
				"_exportImportProcessCommitCallbackRegistry", false);

}