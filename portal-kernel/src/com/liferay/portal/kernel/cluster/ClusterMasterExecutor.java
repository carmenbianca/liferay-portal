/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

import com.liferay.portal.kernel.concurrent.NoticeableFuture;
import com.liferay.portal.kernel.util.MethodHandler;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface ClusterMasterExecutor {

	public void addClusterMasterTokenTransitionListener(
		ClusterMasterTokenTransitionListener
			clusterMasterTokenAcquisitionListener);

	public <T> NoticeableFuture<T> executeOnMaster(MethodHandler methodHandler);

	public boolean isEnabled();

	public boolean isMaster();

	public void removeClusterMasterTokenTransitionListener(
		ClusterMasterTokenTransitionListener
			clusterMasterTokenAcquisitionListener);

}