/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging.config;

import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationEventListener;
import com.liferay.portal.kernel.messaging.MessageBusEventListener;
import com.liferay.portal.kernel.messaging.MessageListener;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public interface MessagingConfigurator {

	public void connect();

	public void destroy();

	public void disconnect();

	public void setDestinationConfigurations(
		Set<DestinationConfiguration> destinationConfigurations);

	public void setDestinationEventListeners(
		Map<String, List<DestinationEventListener>> destinationEventListeners);

	public void setDestinations(List<Destination> destinations);

	public void setMessageBusEventListeners(
		List<MessageBusEventListener> messageBusEventListeners);

	public void setMessageListeners(
		Map<String, List<MessageListener>> messageListeners);

}