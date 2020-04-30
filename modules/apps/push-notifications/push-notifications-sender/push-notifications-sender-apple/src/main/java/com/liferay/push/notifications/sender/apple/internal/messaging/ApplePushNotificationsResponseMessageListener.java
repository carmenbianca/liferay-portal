/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender.apple.internal.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.push.notifications.sender.Response;
import com.liferay.push.notifications.sender.apple.internal.AppleResponse;
import com.liferay.push.notifications.service.PushNotificationsDeviceLocalService;

import com.notnoop.apns.DeliveryError;

/**
 * @author Bruno Farache
 */
public class ApplePushNotificationsResponseMessageListener
	extends BaseMessageListener {

	public ApplePushNotificationsResponseMessageListener(
		PushNotificationsDeviceLocalService
			pushNotificationsDeviceLocalService) {

		_pushNotificationsDeviceLocalService =
			pushNotificationsDeviceLocalService;
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		Response response = (Response)message.getPayload();

		if (response.isSucceeded() || !(response instanceof AppleResponse)) {
			return;
		}

		AppleResponse appleResponse = (AppleResponse)response;

		String invalidTokenErrorName = DeliveryError.INVALID_TOKEN.name();

		if (invalidTokenErrorName.equals(appleResponse.getStatus())) {
			String token = appleResponse.getToken();

			try {
				_pushNotificationsDeviceLocalService.
					deletePushNotificationsDevice(token);

				if (_log.isWarnEnabled()) {
					_log.warn("Token " + token + " is invalid and was deleted");
				}
			}
			catch (Exception exception) {
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ApplePushNotificationsResponseMessageListener.class);

	private final PushNotificationsDeviceLocalService
		_pushNotificationsDeviceLocalService;

}