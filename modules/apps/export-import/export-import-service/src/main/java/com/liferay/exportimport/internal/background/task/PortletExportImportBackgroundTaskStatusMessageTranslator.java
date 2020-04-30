/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.internal.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Daniel Kocsis
 */
public class PortletExportImportBackgroundTaskStatusMessageTranslator
	extends DefaultExportImportBackgroundTaskStatusMessageTranslator {

	@Override
	protected synchronized void translatePortletMessage(
		BackgroundTaskStatus backgroundTaskStatus, Message message) {

		clearBackgroundTaskStatus(backgroundTaskStatus);

		long portletModelAdditionCountersTotal = GetterUtil.getLong(
			message.get("portletModelAdditionCountersTotal"));

		backgroundTaskStatus.setAttribute(
			"allModelAdditionCountersTotal", portletModelAdditionCountersTotal);

		super.translatePortletMessage(backgroundTaskStatus, message);
	}

}