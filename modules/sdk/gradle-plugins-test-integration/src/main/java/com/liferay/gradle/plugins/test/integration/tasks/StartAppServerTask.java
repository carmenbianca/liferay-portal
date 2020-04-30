/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.test.integration.tasks;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import java.util.concurrent.Callable;

import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.TaskAction;

import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.StartedProcess;

/**
 * @author Andrea Di Giorgi
 */
@CacheableTask
public class StartAppServerTask extends BaseAppServerTask {

	@TaskAction
	public void startAppServer() throws Exception {
		if (isReachable()) {
			return;
		}

		OutputStream outputStream = new ByteArrayOutputStream();

		ProcessExecutor processExecutor = getProcessExecutor();

		processExecutor.redirectOutputAlsoTo(outputStream);

		StartedProcess startedProcess = processExecutor.start();

		waitForStarted(startedProcess, outputStream);
	}

	public void waitForReachable() {
		waitFor(
			new Callable<Boolean>() {

				@Override
				public Boolean call() throws Exception {
					return isReachable();
				}

			});
	}

	protected void waitForStarted(
		StartedProcess startedProcess, OutputStream outputStream) {

		waitForReachable();
	}

}