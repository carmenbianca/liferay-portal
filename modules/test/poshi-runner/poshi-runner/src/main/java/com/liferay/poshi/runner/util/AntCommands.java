/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.util;

import com.liferay.poshi.runner.PoshiRunnerGetterUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import java.util.concurrent.Callable;

/**
 * @author Brian Wing Shun Chan
 * @author Michael Hashimoto
 */
public class AntCommands implements Callable<Void> {

	public AntCommands(String fileName, String target) {
		_fileName = fileName;
		_target = target;
	}

	@Override
	public Void call() throws Exception {
		Runtime runtime = Runtime.getRuntime();

		StringBuilder sb = new StringBuilder();

		String projectDirName = PoshiRunnerGetterUtil.getProjectDirName();

		if (!OSDetector.isWindows()) {
			projectDirName = StringUtil.replace(projectDirName, "\\", "//");

			sb.append("/bin/bash ant -f ");
			sb.append(_fileName);
			sb.append(" ");
			sb.append(_target);
			sb.append(" -Dtest.ant.launched.by.selenium=true -Dtest.class=");
			sb.append(PropsValues.TEST_NAME);
		}
		else {
			sb.append("cmd /c ant -f ");
			sb.append(_fileName);
			sb.append(" ");
			sb.append(_target);
			sb.append(" -Dtest.ant.launched.by.selenium=true -Dtest.class=");
			sb.append(PropsValues.TEST_NAME);
		}

		Process process = runtime.exec(
			sb.toString(), null, new File(projectDirName));

		InputStreamReader inputStreamReader = new InputStreamReader(
			process.getInputStream());

		BufferedReader inputBufferedReader = new BufferedReader(
			inputStreamReader);

		String line = null;

		while ((line = inputBufferedReader.readLine()) != null) {
			System.out.println(line);
		}

		InputStreamReader errorStreamReader = new InputStreamReader(
			process.getErrorStream());

		BufferedReader errorBufferedReader = new BufferedReader(
			errorStreamReader);

		if (errorBufferedReader.ready()) {
			while ((line = errorBufferedReader.readLine()) != null) {
				System.out.println(line);
			}

			throw new Exception();
		}

		return null;
	}

	private final String _fileName;
	private final String _target;

}