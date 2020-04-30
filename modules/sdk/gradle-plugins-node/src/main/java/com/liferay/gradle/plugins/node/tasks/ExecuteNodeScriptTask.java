/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.node.tasks;

import com.liferay.gradle.plugins.node.internal.util.FileUtil;
import com.liferay.gradle.plugins.node.internal.util.GradleUtil;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;

/**
 * @author Andrea Di Giorgi
 */
@CacheableTask
public class ExecuteNodeScriptTask extends ExecuteNodeTask {

	@Override
	public void executeNode() throws Exception {
		List<Object> args = getArgs();

		try {
			setArgs(getCompleteArgs());

			super.executeNode();
		}
		finally {
			setArgs(args);
		}
	}

	@Input
	@Optional
	@PathSensitive(PathSensitivity.RELATIVE)
	public File getScriptFile() {
		return GradleUtil.toFile(getProject(), _scriptFile);
	}

	public void setScriptFile(Object scriptFile) {
		_scriptFile = scriptFile;
	}

	protected List<String> getCompleteArgs() {
		File scriptFile = getScriptFile();

		List<String> args = GradleUtil.toStringList(getArgs());

		if (scriptFile == null) {
			return args;
		}

		List<String> completeArgs = new ArrayList<>();

		completeArgs.add(FileUtil.getAbsolutePath(scriptFile));

		completeArgs.addAll(args);

		return completeArgs;
	}

	private Object _scriptFile;

}