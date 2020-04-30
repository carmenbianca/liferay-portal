/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lifecycle;

/**
 * @author Daniel Kocsis
 */
public interface ExportImportLifecycleListenerFactory {

	public ExportImportLifecycleListener create(
		EventAwareExportImportLifecycleListener
			processAwareExportImportLifecycleListener);

	public ExportImportLifecycleListener create(
		ProcessAwareExportImportLifecycleListener
			processAwareExportImportLifecycleListener);

}