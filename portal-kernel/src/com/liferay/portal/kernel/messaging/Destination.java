/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

import java.util.Set;

/**
 * @author Michael C. Han
 */
public interface Destination {

	public boolean addDestinationEventListener(
		DestinationEventListener destinationEventListener);

	public void close();

	public void close(boolean force);

	public void copyDestinationEventListeners(Destination destination);

	public void copyMessageListeners(Destination destination);

	public void destroy();

	public DestinationStatistics getDestinationStatistics();

	public String getDestinationType();

	public int getMessageListenerCount();

	public Set<MessageListener> getMessageListeners();

	public String getName();

	public boolean isRegistered();

	public void open();

	public boolean register(MessageListener messageListener);

	public boolean register(
		MessageListener messageListener, ClassLoader classLoader);

	public boolean removeDestinationEventListener(
		DestinationEventListener destinationEventListener);

	public void removeDestinationEventListeners();

	public void send(Message message);

	public boolean unregister(MessageListener messageListener);

	public void unregisterMessageListeners();

}