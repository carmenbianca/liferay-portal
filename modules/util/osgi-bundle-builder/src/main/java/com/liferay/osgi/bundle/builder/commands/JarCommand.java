/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.bundle.builder.commands;

import aQute.bnd.osgi.Jar;

import com.beust.jcommander.Parameters;

import com.liferay.osgi.bundle.builder.OSGiBundleBuilderArgs;
import com.liferay.osgi.bundle.builder.internal.util.FileUtil;

import java.io.File;

/**
 * @author David Truong
 * @author Andrea Di Giorgi
 */
@Parameters(
	commandDescription = "Generates the JAR file of the OSGi bundle.",
	commandNames = "jar"
)
public class JarCommand extends BaseCommand {

	@Override
	protected void writeOutput(
			Jar jar, OSGiBundleBuilderArgs osgiBundleBuilderArgs)
		throws Exception {

		File outputFile = osgiBundleBuilderArgs.getOutputFile();

		FileUtil.createDirectories(outputFile.getParentFile());

		jar.write(outputFile);
	}

}