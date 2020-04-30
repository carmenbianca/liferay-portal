/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.rest.builder;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;

import java.io.File;

/**
 * @author Peter Shin
 */
public class RESTBuilderArgs {

	public static final String REST_CONFIG_DIR_NAME = ".";

	public File getCopyrightFile() {
		return _copyrightFile;
	}

	public File getRESTConfigDir() {
		return _restConfigDir;
	}

	public void setCopyrightFile(File copyrightFile) {
		_copyrightFile = copyrightFile;
	}

	public void setRESTConfigDir(File restConfigDir) {
		_restConfigDir = restConfigDir;
	}

	protected boolean isHelp() {
		return _help;
	}

	@Parameter(
		converter = FileConverter.class,
		description = "The copyright.txt file which contains the copyright for the source code.",
		names = {"-c", "--copyright-file"}
	)
	private File _copyrightFile;

	@Parameter(
		description = "Print this message.", help = true,
		names = {"-h", "--help"}
	)
	private boolean _help;

	@Parameter(
		converter = FileConverter.class,
		description = "The directory that contains the REST configuration files.",
		names = {"-r", "--rest-config-dir"}
	)
	private File _restConfigDir = new File(REST_CONFIG_DIR_NAME);

}