/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lifecycle;

import java.io.Serializable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Daniel Kocsis
 */
@ProviderType
public interface ExportImportLifecycleEventFactory {

	public ExportImportLifecycleEvent create(
		int code, int processFlag, String processId,
		Serializable... attributes);

}