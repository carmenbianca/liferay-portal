/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lifecycle;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

import java.io.Serializable;

/**
 * @author Daniel Kocsis
 */
public class ExportImportLifecycleEventFactoryUtil {

	public static ExportImportLifecycleEvent create(
		int code, int processFlag, String processId,
		Serializable... attributes) {

		return _exportImportLifecycleEventFactory.create(
			code, processFlag, processId, attributes);
	}

	private static volatile ExportImportLifecycleEventFactory
		_exportImportLifecycleEventFactory =
			ServiceProxyFactory.newServiceTrackedInstance(
				ExportImportLifecycleEventFactory.class,
				ExportImportLifecycleEventFactoryUtil.class,
				"_exportImportLifecycleEventFactory", false);

}