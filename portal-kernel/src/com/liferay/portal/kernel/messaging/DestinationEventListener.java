/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

/**
 * @author Michael C. Han
 */
public interface DestinationEventListener {

	public void messageListenerRegistered(
		String destinationName, MessageListener messageListener);

	public void messageListenerUnregistered(
		String destinationName, MessageListener messageListener);

}