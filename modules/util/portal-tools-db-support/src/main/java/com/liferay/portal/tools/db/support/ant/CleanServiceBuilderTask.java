/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.db.support.ant;

import com.liferay.portal.tools.db.support.commands.CleanServiceBuilderCommand;

import java.io.File;

import org.apache.tools.ant.BuildException;

/**
 * @author Andrea Di Giorgi
 */
public class CleanServiceBuilderTask extends BaseTask {

	@Override
	public void execute() throws BuildException {
		try {
			_cleanServiceBuilderCommand.execute(dbSupportArgs);
		}
		catch (Exception exception) {
			throw new BuildException(exception);
		}
	}

	public void setServiceXmlFile(File serviceXmlFile) {
		_cleanServiceBuilderCommand.setServiceXmlFile(serviceXmlFile);
	}

	public void setServletContextName(String servletContextName) {
		_cleanServiceBuilderCommand.setServletContextName(servletContextName);
	}

	private final CleanServiceBuilderCommand _cleanServiceBuilderCommand =
		new CleanServiceBuilderCommand();

}