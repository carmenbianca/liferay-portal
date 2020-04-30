/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.internal.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Daniel Kocsis
 */
public class LayoutExportImportBackgroundTaskStatusMessageTranslator
	extends DefaultExportImportBackgroundTaskStatusMessageTranslator {

	@Override
	protected synchronized void translateLayoutMessage(
		BackgroundTaskStatus backgroundTaskStatus, Message message) {

		clearBackgroundTaskStatus(backgroundTaskStatus);

		super.translateLayoutMessage(backgroundTaskStatus, message);
	}

}