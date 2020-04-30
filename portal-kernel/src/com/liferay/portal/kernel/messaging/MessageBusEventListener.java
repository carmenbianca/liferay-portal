/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

/**
 * @author Shuyang Zhou
 */
public interface MessageBusEventListener {

	public void destinationAdded(Destination destination);

	public void destinationRemoved(Destination destination);

}