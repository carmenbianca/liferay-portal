/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public abstract class BaseMessageStatusMessageListener
	implements MessageListener {

	@Override
	public void receive(Message message) {
		MessageStatus messageStatus = new MessageStatus();

		messageStatus.startTimer();

		try {
			doReceive(message, messageStatus);
		}
		catch (Exception exception) {
			_log.error(
				"Unable to process request " + message.getDestinationName(),
				exception);

			messageStatus.setException(exception);
		}
		finally {
			messageStatus.stopTimer();

			message = new Message();

			message.setPayload(messageStatus);

			Destination destination = getDestination();

			destination.send(message);
		}
	}

	protected abstract void doReceive(
			Message message, MessageStatus messageStatus)
		throws Exception;

	protected abstract Destination getDestination();

	private static final Log _log = LogFactoryUtil.getLog(
		BaseMessageStatusMessageListener.class);

}