/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.cluster;

import com.liferay.portal.kernel.cluster.ClusterEvent;
import com.liferay.portal.kernel.cluster.ClusterEventListener;
import com.liferay.portal.kernel.cluster.ClusterMasterTokenTransitionListener;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author André de Oliveira
 */
public class ReplicasClusterListener
	implements ClusterEventListener, ClusterMasterTokenTransitionListener {

	public ReplicasClusterListener(
		ReplicasClusterContext replicasClusterContext) {

		_replicasClusterContext = replicasClusterContext;
	}

	@Override
	public void masterTokenAcquired() {
		updateNumberOfReplicas();
	}

	@Override
	public void masterTokenReleased() {
	}

	@Override
	public void processClusterEvent(ClusterEvent clusterEvent) {
		if (_replicasClusterContext.isMaster()) {
			updateNumberOfReplicas();
		}
	}

	protected int getNumberOfReplicas() {
		int liferayClusterSize = _replicasClusterContext.getClusterSize();

		if (liferayClusterSize > 0) {
			return liferayClusterSize - 1;
		}

		return 0;
	}

	protected synchronized void updateNumberOfReplicas() {
		if (!_replicasClusterContext.isEmbeddedOperationMode()) {
			return;
		}

		try {
			ReplicasManager replicasManager =
				_replicasClusterContext.getReplicasManager();

			replicasManager.updateNumberOfReplicas(
				getNumberOfReplicas(),
				_replicasClusterContext.getTargetIndexNames());
		}
		catch (Exception exception) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to update number of replicas", exception);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ReplicasClusterListener.class);

	private final ReplicasClusterContext _replicasClusterContext;

}