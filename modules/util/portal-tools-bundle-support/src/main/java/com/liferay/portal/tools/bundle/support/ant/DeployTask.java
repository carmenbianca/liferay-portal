/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.bundle.support.ant;

import com.liferay.portal.tools.bundle.support.commands.DeployCommand;

import org.apache.tools.ant.BuildException;

/**
 * @author David Truong
 */
public class DeployTask extends DeployCommand {

	@Override
	public void execute() {
		try {
			super.execute();
		}
		catch (Exception exception) {
			throw new BuildException(exception);
		}
	}

}