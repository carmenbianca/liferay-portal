/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lifecycle;

/**
 * @author Daniel Kocsis
 */
public interface ProcessAwareExportImportLifecycleListener
	extends ExportImportLifecycleListener {

	@Override
	public default void onExportImportLifecycleEvent(
			ExportImportLifecycleEvent exportImportLifecycleEvent)
		throws Exception {
	}

	public void onProcessFailed(
			ExportImportLifecycleEvent exportImportLifecycleEvent)
		throws Exception;

	public void onProcessStarted(
			ExportImportLifecycleEvent exportImportLifecycleEvent)
		throws Exception;

	public void onProcessSucceeded(
			ExportImportLifecycleEvent exportImportLifecycleEvent)
		throws Exception;

}