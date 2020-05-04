/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.background.task.internal;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManager;
import com.liferay.portal.kernel.cluster.BaseClusterMasterTokenTransitionListener;
import com.liferay.portal.kernel.cluster.ClusterMasterTokenTransitionListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, service = ClusterMasterTokenTransitionListener.class
)
public class BackgroundTaskClusterMasterTokenTransitionListener
	extends BaseClusterMasterTokenTransitionListener {

	@Reference(unbind = "-")
	public void setBackgroundTaskManager(
		BackgroundTaskManager backgroundTaskManager) {

		_backgroundTaskManager = backgroundTaskManager;
	}

	@Override
	protected void doMasterTokenAcquired() throws Exception {
		_backgroundTaskManager.cleanUpBackgroundTasks();
	}

	@Override
	protected void doMasterTokenReleased() throws Exception {
	}

	private BackgroundTaskManager _backgroundTaskManager;

}