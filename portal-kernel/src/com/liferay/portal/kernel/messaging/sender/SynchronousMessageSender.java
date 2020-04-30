/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging.sender;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusException;

/**
 * @author Michael C. Han
 */
public interface SynchronousMessageSender {

	public Object send(String destinationName, Message message)
		throws MessageBusException;

	public Object send(String destinationName, Message message, long timeout)
		throws MessageBusException;

	public enum Mode {

		DEFAULT, DIRECT

	}

}