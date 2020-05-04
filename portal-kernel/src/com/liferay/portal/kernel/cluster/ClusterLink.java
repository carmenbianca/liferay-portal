/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Shuyang Zhou
 */
public interface ClusterLink {

	public static final int MAX_CHANNEL_COUNT = Priority.values().length;

	public boolean isEnabled();

	public void sendMulticastMessage(Message message, Priority priority);

	public void sendUnicastMessage(
		Address address, Message message, Priority priority);

}