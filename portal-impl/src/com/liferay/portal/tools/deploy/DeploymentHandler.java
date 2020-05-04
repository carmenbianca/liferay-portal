/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.deploy;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.io.File;

import javax.enterprise.deploy.shared.ModuleType;
import javax.enterprise.deploy.shared.factories.DeploymentFactoryManager;
import javax.enterprise.deploy.spi.DeploymentManager;
import javax.enterprise.deploy.spi.TargetModuleID;
import javax.enterprise.deploy.spi.factories.DeploymentFactory;
import javax.enterprise.deploy.spi.status.ProgressObject;

/**
 * @author Sandeep Soni
 * @author Brian Wing Shun Chan
 */
public class DeploymentHandler {

	public DeploymentHandler(
		String dmId, String dmUser, String dmPassword, String dfClassName) {

		DeploymentManager deploymentManager = null;

		try {
			ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();

			DeploymentFactoryManager deploymentFactoryManager =
				DeploymentFactoryManager.getInstance();

			Class<?> clazz = classLoader.loadClass(dfClassName);

			DeploymentFactory deploymentFactory =
				(DeploymentFactory)clazz.newInstance();

			deploymentFactoryManager.registerDeploymentFactory(
				deploymentFactory);

			deploymentManager = deploymentFactoryManager.getDeploymentManager(
				dmId, dmUser, dmPassword);
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		_deploymentManager = deploymentManager;
	}

	public void deploy(File warDir, String warContext) throws Exception {
		setStarted(false);

		ProgressObject deployProgress = null;

		TargetModuleID[] targetModuleIDs =
			_deploymentManager.getAvailableModules(
				ModuleType.WAR, _deploymentManager.getTargets());

		for (TargetModuleID targetModuleID : targetModuleIDs) {
			String moduleID = targetModuleID.getModuleID();

			if (!moduleID.equals(warContext)) {
				continue;
			}

			deployProgress = _deploymentManager.redeploy(
				new TargetModuleID[] {targetModuleID}, warDir, null);

			break;
		}

		if (deployProgress == null) {
			deployProgress = _deploymentManager.distribute(
				_deploymentManager.getTargets(), warDir, null);
		}

		deployProgress.addProgressListener(
			new DeploymentProgressListener(this, warContext));

		waitForStart(warContext);

		if (_error) {
			throw new Exception("Failed to deploy " + warDir);
		}
	}

	public DeploymentManager getDeploymentManager() {
		return _deploymentManager;
	}

	public void releaseDeploymentManager() {
		_deploymentManager.release();
	}

	public synchronized void setError(boolean error) {
		_error = error;
	}

	public synchronized void setStarted(boolean started) {
		_started = started;

		notifyAll();
	}

	protected synchronized void waitForStart(String warContext)
		throws Exception {

		while (!_error && !_started) {
			wait();
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DeploymentHandler.class);

	private final DeploymentManager _deploymentManager;
	private boolean _error;
	private boolean _started;

}