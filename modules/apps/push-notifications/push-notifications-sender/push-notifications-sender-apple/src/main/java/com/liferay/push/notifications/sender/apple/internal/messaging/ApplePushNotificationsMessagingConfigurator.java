/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender.apple.internal.messaging;

import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.push.notifications.constants.PushNotificationsDestinationNames;
import com.liferay.push.notifications.service.PushNotificationsDeviceLocalService;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bruno Farache
 */
@Component(
	enabled = false, immediate = true,
	service = ApplePushNotificationsMessagingConfigurator.class
)
public class ApplePushNotificationsMessagingConfigurator {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_applePushNotificationsResponseMessageListener =
			new ApplePushNotificationsResponseMessageListener(
				_pushNotificationsDeviceLocalService);

		_destination.register(_applePushNotificationsResponseMessageListener);
	}

	@Deactivate
	protected void deactivate() {
		_destination.unregister(_applePushNotificationsResponseMessageListener);
	}

	private MessageListener _applePushNotificationsResponseMessageListener;

	@Reference(
		target = "(destination.name= " + PushNotificationsDestinationNames.PUSH_NOTIFICATION_RESPONSE + ")"
	)
	private Destination _destination;

	@Reference
	private PushNotificationsDeviceLocalService
		_pushNotificationsDeviceLocalService;

}