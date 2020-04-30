/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.bundle.support.ant;

import com.liferay.portal.tools.bundle.support.commands.InitBundleCommand;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 * @author David Truong
 */
public class InitBundleTask extends InitBundleCommand {

	@Override
	public void execute() {
		try {
			super.execute();
		}
		catch (Exception exception) {
			throw new BuildException(exception);
		}
	}

	public void setProject(Project project) {
		_project = project;
	}

	@Override
	protected void onProgress(String message) {
		_project.log(message);
	}

	@Override
	protected void onStarted(String message) {
		_project.log(message);
	}

	private Project _project;

}