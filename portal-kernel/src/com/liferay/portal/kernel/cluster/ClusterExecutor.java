/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

import java.net.InetAddress;
import java.net.NetworkInterface;

import java.util.List;

/**
 * @author Shuyang Zhou
 */
public interface ClusterExecutor {

	public void addClusterEventListener(
		ClusterEventListener clusterEventListener);

	public FutureClusterResponses execute(ClusterRequest clusterRequest);

	public InetAddress getBindInetAddress();

	public NetworkInterface getBindNetworkInterface();

	public List<ClusterEventListener> getClusterEventListeners();

	public List<ClusterNode> getClusterNodes();

	public ClusterNode getLocalClusterNode();

	public boolean isClusterNodeAlive(String clusterNodeId);

	public boolean isEnabled();

	public void removeClusterEventListener(
		ClusterEventListener clusterEventListener);

}