/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.messaging.internal.jmx;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public interface MessageBusManagerMBean {

	public int getDestinationCount();

	public int getMessageListenerCount(String destinationName);

}