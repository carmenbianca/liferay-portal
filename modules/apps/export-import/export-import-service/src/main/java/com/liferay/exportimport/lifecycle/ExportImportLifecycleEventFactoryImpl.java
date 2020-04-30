/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.lifecycle;

import com.liferay.exportimport.kernel.lifecycle.ExportImportLifecycleEvent;
import com.liferay.exportimport.kernel.lifecycle.ExportImportLifecycleEventFactory;

import java.io.Serializable;

import org.osgi.service.component.annotations.Component;

/**
 * @author Daniel Kocsis
 */
@Component(immediate = true, service = ExportImportLifecycleEventFactory.class)
public class ExportImportLifecycleEventFactoryImpl
	implements ExportImportLifecycleEventFactory {

	@Override
	public ExportImportLifecycleEvent create(
		int code, int processFlag, String processId,
		Serializable... attributes) {

		ExportImportLifecycleEvent exportImportLifecycleEvent =
			new ExportImportLifecycleEventImpl();

		exportImportLifecycleEvent.setAttributes(attributes);
		exportImportLifecycleEvent.setCode(code);
		exportImportLifecycleEvent.setProcessFlag(processFlag);
		exportImportLifecycleEvent.setProcessId(processId);

		return exportImportLifecycleEvent;
	}

}