/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.cluster;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @author André de Oliveira
 */
public interface ClusterSettingsContext {

	public String[] getHosts();

	public InetAddress getLocalBindInetAddress();

	public NetworkInterface getLocalBindNetworkInterface();

	public boolean isClusterEnabled();

}