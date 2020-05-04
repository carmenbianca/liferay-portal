/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lar;

import java.util.concurrent.Callable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Daniel Kocsis
 */
@ProviderType
public interface ExportImportProcessCallbackRegistry {

	public void registerCallback(String processId, Callable<?> callable);

}