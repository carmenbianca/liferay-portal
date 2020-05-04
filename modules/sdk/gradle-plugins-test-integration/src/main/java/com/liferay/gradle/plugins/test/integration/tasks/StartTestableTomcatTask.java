/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.test.integration.tasks;

import com.liferay.gradle.plugins.test.integration.internal.util.GradleUtil;

import java.io.File;
import java.io.OutputStream;

import java.util.concurrent.Callable;

import org.gradle.api.InvalidUserDataException;
import org.gradle.api.Project;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;

import org.zeroturnaround.exec.StartedProcess;

/**
 * @author Andrea Di Giorgi
 */
@CacheableTask
public class StartTestableTomcatTask extends StartAppServerTask {

	@Input
	@Optional
	@PathSensitive(PathSensitivity.RELATIVE)
	public File getLiferayHome() {
		return GradleUtil.toFile(getProject(), _liferayHome);
	}

	@Input
	public boolean isDeleteLiferayHome() {
		return _deleteLiferayHome;
	}

	public void setDeleteLiferayHome(boolean deleteLiferayHome) {
		_deleteLiferayHome = deleteLiferayHome;
	}

	public void setLiferayHome(Object liferayHome) {
		_liferayHome = liferayHome;
	}

	@Override
	public void startAppServer() throws Exception {
		if (isDeleteLiferayHome()) {
			_deleteLiferayHome();
		}

		super.startAppServer();
	}

	@Override
	protected void waitForStarted(
		StartedProcess startedProcess, final OutputStream outputStream) {

		waitFor(
			new Callable<Boolean>() {

				@Override
				public Boolean call() throws Exception {
					String output = outputStream.toString();

					if (output.contains("Server startup in")) {
						return true;
					}

					return false;
				}

			});
	}

	private void _deleteLiferayHome() {
		Project project = getProject();

		File liferayHome = getLiferayHome();

		if (liferayHome == null) {
			throw new InvalidUserDataException(
				"No value has been specified for property 'liferayHome'");
		}

		project.delete(
			new File(liferayHome, "data"), new File(liferayHome, "logs"),
			new File(liferayHome, "osgi/state"),
			new File(liferayHome, "portal-setup-wizard.properties"));
	}

	private boolean _deleteLiferayHome = true;
	private Object _liferayHome;

}