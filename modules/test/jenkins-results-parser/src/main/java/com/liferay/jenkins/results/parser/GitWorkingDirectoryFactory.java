/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public class GitWorkingDirectoryFactory {

	public static GitWorkingDirectory newGitWorkingDirectory(
		String upstreamBranchName, File gitRepositoryDir,
		String gitRepositoryName) {

		if ((gitRepositoryDir == null) && (gitRepositoryName == null)) {
			throw new IllegalArgumentException(
				"Git repository directory and Git repository name are null");
		}

		String gitRepositoryDirName = gitRepositoryName;

		if (gitRepositoryDir == null) {
			if (gitRepositoryName.equals("liferay-portal") &&
				!upstreamBranchName.equals("master")) {

				gitRepositoryName += "-ee";

				gitRepositoryDirName = "liferay-portal-" + upstreamBranchName;
			}

			if (gitRepositoryName.startsWith("com-liferay-") &&
				!gitRepositoryName.endsWith("-private")) {

				gitRepositoryDirName = gitRepositoryName + "-private";
			}

			gitRepositoryDir = new File(
				JenkinsResultsParserUtil.getBaseGitRepositoryDir(),
				gitRepositoryDirName);
		}

		if (!gitRepositoryDir.exists()) {
			throw new RuntimeException(
				"Directory path not found " + gitRepositoryDir);
		}

		try {
			String gitRepositoryDirPath =
				JenkinsResultsParserUtil.getCanonicalPath(gitRepositoryDir);

			String key = JenkinsResultsParserUtil.combine(
				gitRepositoryDirPath, "-", upstreamBranchName);

			if (_gitWorkingDirectories.containsKey(key)) {
				return _gitWorkingDirectories.get(key);
			}

			GitWorkingDirectory gitWorkingDirectory = null;

			if (gitRepositoryName.startsWith("com-liferay-")) {
				gitWorkingDirectory = new SubrepositoryGitWorkingDirectory(
					upstreamBranchName, gitRepositoryDirPath,
					gitRepositoryName);
			}
			else if (gitRepositoryName.startsWith("liferay-plugins")) {
				gitWorkingDirectory = new PluginsGitWorkingDirectory(
					upstreamBranchName, gitRepositoryDirPath,
					gitRepositoryName);
			}
			else if (gitRepositoryName.startsWith("liferay-portal")) {
				gitWorkingDirectory = new PortalGitWorkingDirectory(
					upstreamBranchName, gitRepositoryDirPath,
					gitRepositoryName);
			}
			else {
				gitWorkingDirectory = new GitWorkingDirectory(
					upstreamBranchName, gitRepositoryDirPath,
					gitRepositoryName);
			}

			_gitWorkingDirectories.put(key, gitWorkingDirectory);

			return gitWorkingDirectory;
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				JenkinsResultsParserUtil.combine(
					"Unable to create Git working directory for directory ",
					gitRepositoryDir.getPath()),
				ioException);
		}
	}

	public static GitWorkingDirectory newGitWorkingDirectory(
		String upstreamBranchName, String gitepositoryDirPath) {

		return newGitWorkingDirectory(
			upstreamBranchName, new File(gitepositoryDirPath), null);
	}

	public static GitWorkingDirectory newGitWorkingDirectory(
		String upstreamBranchName, String gitRepositoryDirPath,
		String gitRepositoryName) {

		if (gitRepositoryDirPath == null) {
			return newGitWorkingDirectory(
				upstreamBranchName, (File)null, gitRepositoryName);
		}

		return newGitWorkingDirectory(
			upstreamBranchName, new File(gitRepositoryDirPath),
			gitRepositoryName);
	}

	public static GitWorkingDirectory newJenkinsGitWorkingDirectory() {
		return newGitWorkingDirectory(
			"master",
			new File(
				JenkinsResultsParserUtil.getBaseGitRepositoryDir(),
				"liferay-jenkins-ee"),
			"liferay-jenkins-ee");
	}

	public static PortalGitWorkingDirectory newPortalGitWorkingDirectory(
		String upstreamBranchName) {

		return (PortalGitWorkingDirectory)newGitWorkingDirectory(
			upstreamBranchName, (File)null, "liferay-portal");
	}

	public static SubrepositoryGitWorkingDirectory
		newSubrepositoryGitWorkingDirectory(
			String upstreamBranchName, String gitRepositoryName) {

		return (SubrepositoryGitWorkingDirectory)newGitWorkingDirectory(
			upstreamBranchName, (File)null, gitRepositoryName);
	}

	private static final Map<String, GitWorkingDirectory>
		_gitWorkingDirectories = new HashMap<>();

}