/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.node.tasks;

import com.liferay.gradle.plugins.node.internal.util.FileUtil;
import com.liferay.gradle.plugins.node.internal.util.GradleUtil;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.gradle.api.tasks.CacheableTask;

/**
 * @author Peter Shin
 */
@CacheableTask
public class YarnInstallTask extends ExecutePackageManagerTask {

	@Override
	public synchronized void executeNode() throws Exception {
		File yarnrcFile = _getYarnrcFile();

		if (!yarnrcFile.exists()) {
			_createYarnrcFile(yarnrcFile);
		}

		super.executeNode();
	}

	public boolean isFrozenLockFile() {
		return GradleUtil.toBoolean(_frozenLockFile);
	}

	public void setFrozenLockFile(Object frozenLockFile) {
		_frozenLockFile = frozenLockFile;
	}

	@Override
	protected List<String> getCompleteArgs() {
		List<String> completeArgs = super.getCompleteArgs();

		completeArgs.add("install");

		if (isFrozenLockFile()) {
			completeArgs.add("--frozen-lockfile");
		}

		return completeArgs;
	}

	private void _createYarnrcFile(File yarnrcFile) throws IOException {
		List<String> contents = new ArrayList<>(2);

		contents.add("disable-self-update-check true");
		contents.add("yarn-offline-mirror \"./node_modules_cache\"");
		contents.add("yarn-offline-mirror-pruning true");

		FileUtil.write(yarnrcFile, contents);
	}

	private File _getYarnrcFile() {
		File scriptFile = getScriptFile();

		return new File(scriptFile.getParentFile(), ".yarnrc");
	}

	private Object _frozenLockFile;

}