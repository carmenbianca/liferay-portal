/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cluster.multiple.internal;

import com.liferay.portal.kernel.cluster.Address;

import java.io.Serializable;

import java.net.InetAddress;

/**
 * @author Tina Tian
 */
public interface ClusterChannel {

	public void close();

	public InetAddress getBindInetAddress();

	public String getClusterName();

	public ClusterReceiver getClusterReceiver();

	public Address getLocalAddress();

	public void sendMulticastMessage(Serializable message);

	public void sendUnicastMessage(Serializable message, Address address);

}