/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.background.task.internal.messaging;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusMessageSender;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskThreadLocal;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andrew Betts
 */
@Component(immediate = true, service = BackgroundTaskStatusMessageSender.class)
public class BackgroundTaskStatusMessageSenderImpl
	implements BackgroundTaskStatusMessageSender {

	@Override
	public void sendBackgroundTaskStatusMessage(Message message) {
		if (!BackgroundTaskThreadLocal.hasBackgroundTask()) {
			return;
		}

		String destinationName = message.getDestinationName();

		if (Validator.isNull(destinationName)) {
			destinationName = DestinationNames.BACKGROUND_TASK_STATUS;

			message.setDestinationName(destinationName);
		}

		_messageBus.sendMessage(destinationName, message);
	}

	@Reference(unbind = "-")
	protected void setMessageBus(MessageBus messageBus) {
		_messageBus = messageBus;
	}

	private MessageBus _messageBus;

}