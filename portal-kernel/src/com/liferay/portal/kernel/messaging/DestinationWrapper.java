/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

import java.util.Set;

/**
 * @author Shuyang Zhou
 */
public class DestinationWrapper implements Destination {

	public DestinationWrapper(Destination destination) {
		this.destination = destination;
	}

	@Override
	public boolean addDestinationEventListener(
		DestinationEventListener destinationEventListener) {

		return destination.addDestinationEventListener(
			destinationEventListener);
	}

	@Override
	public void close() {
		destination.close();
	}

	@Override
	public void close(boolean force) {
		destination.close(force);
	}

	@Override
	public void copyDestinationEventListeners(Destination destination) {
		this.destination.copyDestinationEventListeners(destination);
	}

	@Override
	public void copyMessageListeners(Destination destination) {
		this.destination.copyMessageListeners(destination);
	}

	@Override
	public void destroy() {
		this.destination.destroy();
	}

	@Override
	public DestinationStatistics getDestinationStatistics() {
		return destination.getDestinationStatistics();
	}

	@Override
	public String getDestinationType() {
		return destination.getDestinationType();
	}

	@Override
	public int getMessageListenerCount() {
		return destination.getMessageListenerCount();
	}

	@Override
	public Set<MessageListener> getMessageListeners() {
		return destination.getMessageListeners();
	}

	@Override
	public String getName() {
		return destination.getName();
	}

	@Override
	public boolean isRegistered() {
		return destination.isRegistered();
	}

	@Override
	public void open() {
		destination.open();
	}

	@Override
	public boolean register(MessageListener messageListener) {
		return destination.register(messageListener);
	}

	@Override
	public boolean register(
		MessageListener messageListener, ClassLoader classLoader) {

		return destination.register(messageListener, classLoader);
	}

	@Override
	public boolean removeDestinationEventListener(
		DestinationEventListener destinationEventListener) {

		return destination.removeDestinationEventListener(
			destinationEventListener);
	}

	@Override
	public void removeDestinationEventListeners() {
		destination.removeDestinationEventListeners();
	}

	@Override
	public void send(Message message) {
		destination.send(message);
	}

	@Override
	public boolean unregister(MessageListener messageListener) {
		return destination.unregister(messageListener);
	}

	@Override
	public void unregisterMessageListeners() {
		destination.unregisterMessageListeners();
	}

	protected Destination destination;

}