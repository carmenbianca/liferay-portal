/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Shuyang Zhou
 * @author Raymond Augé
 */
public class ClusterLinkUtil {

	public static Address getAddress(Message message) {
		return (Address)message.get(_ADDRESS);
	}

	public static void sendMulticastMessage(
		Message message, Priority priority) {

		_getClusterLink().sendMulticastMessage(message, priority);
	}

	public static void sendMulticastMessage(Object payload, Priority priority) {
		Message message = new Message();

		message.setPayload(payload);

		sendMulticastMessage(message, priority);
	}

	public static void sendUnicastMessage(
		Address address, Message message, Priority priority) {

		_getClusterLink().sendUnicastMessage(address, message, priority);
	}

	public static Message setAddress(Message message, Address address) {
		message.put(_ADDRESS, address);

		return message;
	}

	private static ClusterLink _getClusterLink() {
		return _clusterLink;
	}

	private static final String _ADDRESS = "CLUSTER_ADDRESS";

	private static volatile ClusterLink _clusterLink =
		ServiceProxyFactory.newServiceTrackedInstance(
			ClusterLink.class, ClusterLinkUtil.class, "_clusterLink", false);

}