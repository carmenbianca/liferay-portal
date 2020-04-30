/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lifecycle;

/**
 * @author Daniel Kocsis
 */
public interface ExportImportLifecycleListener {

	public boolean isParallel();

	public void onExportImportLifecycleEvent(
			ExportImportLifecycleEvent exportImportLifecycleEvent)
		throws Exception;

}