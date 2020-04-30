/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

/**
 * @author Tina Tian
 */
public interface MessageBusInterceptor {

	public boolean intercept(
		MessageBus messageBus, String destinationName, Message message);

}