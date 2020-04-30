/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.internal.lar;

import com.liferay.exportimport.kernel.lar.ExportImportProcessCallbackRegistry;

import java.util.concurrent.Callable;

import org.osgi.service.component.annotations.Component;

/**
 * @author Daniel Kocsis
 */
@Component(
	immediate = true, service = ExportImportProcessCallbackRegistry.class
)
public class ExportImportProcessCallbackRegistryImpl
	implements ExportImportProcessCallbackRegistry {

	@Override
	public void registerCallback(String processId, Callable<?> callable) {
		ExportImportProcessCallbackUtil.registerCallback(processId, callable);
	}

}