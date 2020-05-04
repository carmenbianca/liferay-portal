/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.lifecycle;

import com.liferay.exportimport.kernel.lifecycle.EventAwareExportImportLifecycleListener;
import com.liferay.exportimport.kernel.lifecycle.ExportImportLifecycleListener;
import com.liferay.exportimport.kernel.lifecycle.ExportImportLifecycleListenerFactory;
import com.liferay.exportimport.kernel.lifecycle.ProcessAwareExportImportLifecycleListener;

import org.osgi.service.component.annotations.Component;

/**
 * @author Daniel Kocsis
 */
@Component(
	immediate = true, service = ExportImportLifecycleListenerFactory.class
)
public class DefaultExportImportLifecycleListernerFactory
	implements ExportImportLifecycleListenerFactory {

	@Override
	public ExportImportLifecycleListener create(
		EventAwareExportImportLifecycleListener lifecycleListener) {

		return new DefaultEventAwareExportImportLifecycleListener(
			lifecycleListener);
	}

	@Override
	public ExportImportLifecycleListener create(
		ProcessAwareExportImportLifecycleListener lifecycleListener) {

		return new DefaultProcessAwareExportImportLifecycleListener(
			lifecycleListener);
	}

}