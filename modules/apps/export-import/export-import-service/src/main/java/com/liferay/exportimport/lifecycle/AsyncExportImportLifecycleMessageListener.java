/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.lifecycle;

import com.liferay.exportimport.kernel.lifecycle.ExportImportLifecycleEventListenerRegistryUtil;
import com.liferay.exportimport.kernel.lifecycle.ExportImportLifecycleListener;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Daniel Kocsis
 */
@Component(
	immediate = true,
	property = "destination.name=" + DestinationNames.EXPORT_IMPORT_LIFECYCLE_EVENT_ASYNC,
	service = MessageListener.class
)
public class AsyncExportImportLifecycleMessageListener
	extends BaseExportImportLifecycleMessageListener {

	@Override
	protected Set<ExportImportLifecycleListener>
		getExportImportLifecycleListeners(Message message) {

		return ExportImportLifecycleEventListenerRegistryUtil.
			getAsyncExportImportLifecycleListeners();
	}

	@Reference(
		target = "(destination.name=" + DestinationNames.EXPORT_IMPORT_LIFECYCLE_EVENT_ASYNC + ")",
		unbind = "-"
	)
	protected void setDestination(Destination destination) {
	}

}