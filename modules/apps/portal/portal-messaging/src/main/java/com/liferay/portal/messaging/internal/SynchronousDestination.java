/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.messaging.internal;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseDestination;
import com.liferay.portal.kernel.messaging.DestinationStatistics;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Shuyang Zhou
 */
public class SynchronousDestination extends BaseDestination {

	@Override
	public DestinationStatistics getDestinationStatistics() {
		DestinationStatistics destinationStatistics =
			new DestinationStatistics();

		destinationStatistics.setSentMessageCount(_sentMessageCounter.get());

		return destinationStatistics;
	}

	@Override
	public void send(Message message) {
		for (MessageListener messageListener : messageListeners) {
			try {
				messageListener.receive(message);
			}
			catch (MessageListenerException messageListenerException) {
				_log.error(
					"Unable to process message " + message,
					messageListenerException);
			}
		}

		_sentMessageCounter.incrementAndGet();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SynchronousDestination.class);

	private final AtomicLong _sentMessageCounter = new AtomicLong();

}