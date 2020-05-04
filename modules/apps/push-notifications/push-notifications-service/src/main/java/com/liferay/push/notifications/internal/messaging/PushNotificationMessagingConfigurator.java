/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.internal.messaging;

import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationFactory;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.push.notifications.constants.PushNotificationsDestinationNames;
import com.liferay.push.notifications.service.PushNotificationsDeviceLocalService;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, service = PushNotificationMessagingConfigurator.class
)
public class PushNotificationMessagingConfigurator {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		DestinationConfiguration pushNotificationDestinationConfiguration =
			new DestinationConfiguration(
				DestinationConfiguration.DESTINATION_TYPE_SERIAL,
				PushNotificationsDestinationNames.PUSH_NOTIFICATION);

		Destination pushNotificationDestination = registerDestination(
			pushNotificationDestinationConfiguration);

		MessageListener pushNotificationsMessageListener =
			new PushNotificationsMessageListener(
				_pushNotificationsDeviceLocalService);

		pushNotificationDestination.register(pushNotificationsMessageListener);

		DestinationConfiguration
			pushNotificationResponseDestinationConfiguration =
				new DestinationConfiguration(
					DestinationConfiguration.DESTINATION_TYPE_SERIAL,
					PushNotificationsDestinationNames.
						PUSH_NOTIFICATION_RESPONSE);

		Destination pushNotificationResponseDestination = registerDestination(
			pushNotificationResponseDestinationConfiguration);

		MessageListener pushNotificationsResponseMessageListener =
			new PushNotificationsResponseMessageListener(_jsonFactory);

		pushNotificationResponseDestination.register(
			pushNotificationsResponseMessageListener);
	}

	@Deactivate
	protected void deactivate() {
		if (!_serviceRegistrations.isEmpty()) {
			for (ServiceRegistration<Destination> serviceRegistration :
					_serviceRegistrations.values()) {

				Destination destination = _bundleContext.getService(
					serviceRegistration.getReference());

				serviceRegistration.unregister();

				destination.destroy();
			}

			_serviceRegistrations.clear();
		}

		_bundleContext = null;
	}

	protected Destination registerDestination(
		DestinationConfiguration destinationConfiguration) {

		Destination destination = _destinationFactory.createDestination(
			destinationConfiguration);

		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("destination.name", destination.getName());

		ServiceRegistration<Destination> serviceRegistration =
			_bundleContext.registerService(
				Destination.class, destination, properties);

		_serviceRegistrations.put(destination.getName(), serviceRegistration);

		return destination;
	}

	private BundleContext _bundleContext;

	@Reference
	private DestinationFactory _destinationFactory;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private PushNotificationsDeviceLocalService
		_pushNotificationsDeviceLocalService;

	private final Map<String, ServiceRegistration<Destination>>
		_serviceRegistrations = new HashMap<>();

}