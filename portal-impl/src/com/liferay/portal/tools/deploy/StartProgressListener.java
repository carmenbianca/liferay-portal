/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.deploy;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.enterprise.deploy.spi.status.DeploymentStatus;
import javax.enterprise.deploy.spi.status.ProgressEvent;
import javax.enterprise.deploy.spi.status.ProgressListener;

/**
 * @author Sandeep Soni
 * @author Brian Wing Shun Chan
 * @author Deepak Gothe
 */
public class StartProgressListener implements ProgressListener {

	public StartProgressListener(DeploymentHandler deploymentHandler) {
		_deploymentHandler = deploymentHandler;
	}

	@Override
	public void handleProgressEvent(ProgressEvent progressEvent) {
		DeploymentStatus deploymentStatus = progressEvent.getDeploymentStatus();

		if (_log.isInfoEnabled()) {
			_log.info(deploymentStatus.getMessage());
		}

		if (deploymentStatus.isCompleted()) {
			_deploymentHandler.setError(false);
			_deploymentHandler.setStarted(true);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		StartProgressListener.class);

	private final DeploymentHandler _deploymentHandler;

}