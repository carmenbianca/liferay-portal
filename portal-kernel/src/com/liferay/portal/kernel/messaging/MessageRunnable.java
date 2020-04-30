/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

/**
 * @author Shuyang Zhou
 */
public abstract class MessageRunnable implements Runnable {

	public MessageRunnable(Message message) {
		_message = message;
	}

	public Message getMessage() {
		return _message;
	}

	private final Message _message;

}