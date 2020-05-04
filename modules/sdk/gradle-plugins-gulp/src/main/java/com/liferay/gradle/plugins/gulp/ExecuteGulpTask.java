/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.gulp;

import com.liferay.gradle.plugins.node.tasks.ExecuteNodeScriptTask;
import com.liferay.gradle.util.GradleUtil;

import java.util.List;

import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;

/**
 * @author David Truong
 * @author Andrea Di Giorgi
 */
@CacheableTask
public class ExecuteGulpTask extends ExecuteNodeScriptTask {

	public ExecuteGulpTask() {
		setScriptFile("node_modules/gulp/bin/gulp.js");
	}

	@Input
	public String getGulpCommand() {
		return GradleUtil.toString(_gulpCommand);
	}

	public void setGulpCommand(Object gulpCommand) {
		_gulpCommand = gulpCommand;
	}

	@Override
	protected List<String> getCompleteArgs() {
		List<String> completeArgs = super.getCompleteArgs();

		completeArgs.add(getGulpCommand());

		return completeArgs;
	}

	private Object _gulpCommand;

}