/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import java.util.concurrent.TimeoutException;

/**
 * @author Michael Hashimoto
 */
public class BuildDatabaseUtil {

	public static BuildDatabase getBuildDatabase() {
		return getBuildDatabase(null, true);
	}

	public static BuildDatabase getBuildDatabase(
		String baseDirPath, boolean download) {

		if (_buildDatabase != null) {
			return _buildDatabase;
		}

		if (baseDirPath == null) {
			baseDirPath = System.getenv("WORKSPACE");

			if (baseDirPath == null) {
				throw new RuntimeException("Please set WORKSPACE");
			}
		}

		File baseDir = new File(baseDirPath);

		if (!baseDir.exists()) {
			baseDir.mkdirs();
		}

		String distNodes = System.getenv("DIST_NODES");
		String distPath = System.getenv("DIST_PATH");

		if ((distNodes != null) && (distPath != null) && download) {
			_downloadBuildDatabaseFile(baseDir, distNodes, distPath);
		}

		_buildDatabase = new DefaultBuildDatabase(baseDir);

		return _buildDatabase;
	}

	private static void _downloadBuildDatabaseFile(
		File baseDir, String distNodes, String distPath) {

		File buildDatabaseFile = new File(
			baseDir, BuildDatabase.FILE_NAME_BUILD_DATABASE);

		if (buildDatabaseFile.exists()) {
			return;
		}

		if (!JenkinsResultsParserUtil.isCINode()) {
			try {
				JenkinsResultsParserUtil.write(buildDatabaseFile, "{}");
			}
			catch (IOException ioException) {
				throw new RuntimeException(ioException);
			}

			return;
		}

		int maxRetries = 5;
		int retries = 0;

		while (retries < maxRetries) {
			try {
				retries++;

				String distNode = JenkinsResultsParserUtil.getRandomString(
					Arrays.asList(distNodes.split(",")));

				String command = JenkinsResultsParserUtil.combine(
					"time rsync -Iqs --timeout=1200 ", distNode, ":", distPath,
					"/", BuildDatabase.FILE_NAME_BUILD_DATABASE, " ",
					JenkinsResultsParserUtil.getCanonicalPath(
						buildDatabaseFile));

				command = command.replaceAll("\\(", "\\\\(");
				command = command.replaceAll("\\)", "\\\\)");

				Process process = JenkinsResultsParserUtil.executeBashCommands(
					true, command);

				if (process.exitValue() != 0) {
					throw new RuntimeException(
						JenkinsResultsParserUtil.combine(
							"Unable to download ",
							BuildDatabase.FILE_NAME_BUILD_DATABASE));
				}

				break;
			}
			catch (IOException | RuntimeException | TimeoutException
						exception) {

				if (retries == maxRetries) {
					throw new RuntimeException(
						JenkinsResultsParserUtil.combine(
							"Unable to get ",
							BuildDatabase.FILE_NAME_BUILD_DATABASE, " file"),
						exception);
				}

				System.out.println(
					"Unable to execute bash commands, retrying... ");

				exception.printStackTrace();

				JenkinsResultsParserUtil.sleep(3000);
			}
		}
	}

	private static BuildDatabase _buildDatabase;

}