/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.soy.builder.ant;

import com.liferay.portal.tools.soy.builder.commands.BuildSoyCommand;

import org.apache.tools.ant.BuildException;

/**
 * @author Andrea Di Giorgi
 */
public class BuildSoyTask extends BuildSoyCommand {

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