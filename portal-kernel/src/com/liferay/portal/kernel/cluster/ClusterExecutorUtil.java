/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

import java.util.List;

/**
 * @author Tina Tian
 * @author Raymond Augé
 */
public class ClusterExecutorUtil {

	public static void addClusterEventListener(
		ClusterEventListener clusterEventListener) {

		_getClusterExecutor().addClusterEventListener(clusterEventListener);
	}

	public static FutureClusterResponses execute(
		ClusterRequest clusterRequest) {

		return _getClusterExecutor().execute(clusterRequest);
	}

	public static List<ClusterNode> getClusterNodes() {
		return _getClusterExecutor().getClusterNodes();
	}

	public static ClusterNode getLocalClusterNode() {
		return _getClusterExecutor().getLocalClusterNode();
	}

	public static boolean isClusterNodeAlive(String clusterNodeId) {
		return _getClusterExecutor().isClusterNodeAlive(clusterNodeId);
	}

	public static boolean isEnabled() {
		return _getClusterExecutor().isEnabled();
	}

	public static void removeClusterEventListener(
		ClusterEventListener clusterEventListener) {

		_getClusterExecutor().removeClusterEventListener(clusterEventListener);
	}

	private static ClusterExecutor _getClusterExecutor() {
		return _clusterExecutor;
	}

	private static volatile ClusterExecutor _clusterExecutor =
		ServiceProxyFactory.newServiceTrackedInstance(
			ClusterExecutor.class, ClusterExecutorUtil.class,
			"_clusterExecutor", false);

}