/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.rest.builder;

import com.liferay.gradle.util.GradleUtil;
import com.liferay.gradle.util.Validator;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.JavaExec;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;

/**
 * @author Peter Shin
 */
@CacheableTask
public class BuildRESTTask extends JavaExec {

	public BuildRESTTask() {
		setMain("com.liferay.portal.tools.rest.builder.RESTBuilder");
	}

	@Override
	public void exec() {
		setArgs(_getCompleteArgs());

		super.exec();
	}

	@InputFile
	@Optional
	@PathSensitive(PathSensitivity.RELATIVE)
	public File getCopyrightFile() {
		return GradleUtil.toFile(getProject(), _copyrightFile);
	}

	@InputDirectory
	@PathSensitive(PathSensitivity.RELATIVE)
	public File getRESTConfigDir() {
		return GradleUtil.toFile(getProject(), _restConfigDir);
	}

	public void setCopyrightFile(Object copyrightFile) {
		_copyrightFile = copyrightFile;
	}

	public void setRESTConfigDir(Object restConfigDir) {
		_restConfigDir = restConfigDir;
	}

	private static void _addArg(List<String> args, String name, File file) {
		if (file != null) {
			_addArg(args, name, file.getAbsolutePath());
		}
	}

	private static void _addArg(List<String> args, String name, String value) {
		if (Validator.isNotNull(value)) {
			args.add(name);
			args.add(value);
		}
	}

	private List<String> _getCompleteArgs() {
		List<String> args = new ArrayList<>(getArgs());

		_addArg(args, "--copyright-file", getCopyrightFile());
		_addArg(args, "--rest-config-dir", getRESTConfigDir());

		return args;
	}

	private Object _copyrightFile;
	private Object _restConfigDir;

}