/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.pop;

import javax.mail.Message;

/**
 * @author Brian Wing Shun Chan
 */
public interface MessageListener {

	public boolean accept(String from, String recipient, Message message);

	public void deliver(String from, String recipient, Message message)
		throws MessageListenerException;

	public String getId();

}