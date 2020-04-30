/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.node.tasks;

import com.liferay.gradle.plugins.node.internal.util.GradleUtil;

import java.util.List;

import org.gradle.api.tasks.CacheableTask;

/**
 * @author David Truong
 * @author Peter Shin
 */
@CacheableTask
public class PackageRunTask extends ExecutePackageManagerTask {

	public String getScriptName() {
		return GradleUtil.toString(_scriptName);
	}

	public void setScriptName(Object scriptName) {
		_scriptName = scriptName;
	}

	@Override
	protected List<String> getCompleteArgs() {
		List<String> completeArgs = super.getCompleteArgs();

		if (isUseNpm()) {
			completeArgs.add("run-script");
		}
		else {
			completeArgs.add("run");
		}

		completeArgs.add(getScriptName());

		return completeArgs;
	}

	private Object _scriptName;

}