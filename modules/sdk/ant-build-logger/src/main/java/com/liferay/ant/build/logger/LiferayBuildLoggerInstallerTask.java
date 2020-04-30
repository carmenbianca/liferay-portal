/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.ant.build.logger;

import java.lang.reflect.Field;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

/**
 * @author William Newbury
 * @author Shuyang Zhou
 */
public class LiferayBuildLoggerInstallerTask extends Task {

	@Override
	public void execute() throws BuildException {
		Project currentProject = getProject();

		try {
			synchronized(_listenersLockField.get(currentProject)) {
				for (BuildListener buildListener :
						currentProject.getBuildListeners()) {

					if (buildListener.getClass() != DefaultLogger.class) {
						continue;
					}

					boolean buildPerformanceLoggerEnabled =
						isBuildPerformanceLoggerEnabled();

					currentProject.removeBuildListener(buildListener);

					currentProject.addBuildListener(
						new LiferayBuildLogger(buildListener));

					if (buildPerformanceLoggerEnabled) {
						currentProject.addBuildListener(
							new LiferayBuildPerformanceLogger());
					}
				}
			}
		}
		catch (IllegalAccessException iae) {
			throw new BuildException(
				"Unable to access listenersLock field of " + currentProject,
				iae);
		}
	}

	private boolean isBuildPerformanceLoggerEnabled() {
		Project project = getProject();

		String buildPerformanceLoggerEnabled = project.getProperty(
			"build.performance.logger.enabled");

		if ((buildPerformanceLoggerEnabled != null) &&
			buildPerformanceLoggerEnabled.equals("true")) {

			return true;
		}

		return false;
	}

	private static final Field _listenersLockField;

	static {
		try {
			_listenersLockField = Project.class.getDeclaredField(
				"listenersLock");

			_listenersLockField.setAccessible(true);
		}
		catch (ReflectiveOperationException roe) {
			throw new ExceptionInInitializerError(roe);
		}
	}

}