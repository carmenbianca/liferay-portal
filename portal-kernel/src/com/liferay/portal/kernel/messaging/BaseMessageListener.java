/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public abstract class BaseMessageListener implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		try {
			doReceive(message);
		}
		catch (MessageListenerException messageListenerException) {
			throw messageListenerException;
		}
		catch (Exception exception) {
			throw new MessageListenerException(exception);
		}
	}

	protected abstract void doReceive(Message message) throws Exception;

}