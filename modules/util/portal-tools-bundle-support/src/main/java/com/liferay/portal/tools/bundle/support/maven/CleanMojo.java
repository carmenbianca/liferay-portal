/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.bundle.support.maven;

import com.liferay.portal.tools.bundle.support.commands.CleanCommand;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author David Truong
 */
@Mojo(defaultPhase = LifecyclePhase.CLEAN, name = "clean")
public class CleanMojo extends AbstractLiferayMojo {

	@Override
	public void execute() throws MojoExecutionException {
		String packaging = project.getPackaging();

		if (!packaging.equals("jar") && !packaging.equals("war")) {
			return;
		}

		try {
			CleanCommand cleanCommand = new CleanCommand();

			cleanCommand.setFileName(fileName);
			cleanCommand.setLiferayHomeDir(getLiferayHomeDir());

			cleanCommand.execute();
		}
		catch (Exception exception) {
			throw new MojoExecutionException(
				"Unable to clean " + fileName, exception);
		}
	}

	@Parameter(
		defaultValue = "${project.artifactId}.${project.packaging}",
		required = true
	)
	protected String fileName;

}