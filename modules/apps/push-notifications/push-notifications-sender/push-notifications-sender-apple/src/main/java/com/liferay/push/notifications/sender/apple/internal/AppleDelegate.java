/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender.apple.internal;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.push.notifications.constants.PushNotificationsDestinationNames;

import com.notnoop.apns.ApnsDelegate;
import com.notnoop.apns.ApnsNotification;
import com.notnoop.apns.DeliveryError;

/**
 * @author Bruno Farache
 */
public class AppleDelegate implements ApnsDelegate {

	public AppleDelegate(MessageBus messageBus) {
		_messageBus = messageBus;
	}

	@Override
	public void cacheLengthExceeded(int newCacheLength) {
	}

	@Override
	public void connectionClosed(DeliveryError deliveryError, int identifier) {
	}

	@Override
	public void messageSendFailed(
		ApnsNotification notification, Throwable throwable) {

		sendResponse(new AppleResponse(notification, throwable));
	}

	@Override
	public void messageSent(ApnsNotification notification, boolean resent) {
		sendResponse(new AppleResponse(notification, resent));
	}

	@Override
	public void notificationsResent(int resendCount) {
	}

	protected void sendResponse(AppleResponse appleResponse) {
		Message message = new Message();

		message.setPayload(appleResponse);

		_messageBus.sendMessage(
			PushNotificationsDestinationNames.PUSH_NOTIFICATION_RESPONSE,
			message);
	}

	private final MessageBus _messageBus;

}