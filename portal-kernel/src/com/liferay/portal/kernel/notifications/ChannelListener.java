/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.notifications;

/**
 * @author Edward Han
 */
public interface ChannelListener {

	public void channelListenerRemoved(long channelId);

	public void notificationEventsAvailable(long channelId);

}