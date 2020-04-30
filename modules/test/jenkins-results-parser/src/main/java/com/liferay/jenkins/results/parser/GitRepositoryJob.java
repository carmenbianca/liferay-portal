/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michael Hashimoto
 */
public abstract class GitRepositoryJob extends BaseJob {

	public String getBranchName() {
		if (_branchName != null) {
			return _branchName;
		}

		Matcher matcher = _jobNamePattern.matcher(getJobName());

		if (matcher.find()) {
			_branchName = matcher.group("branchName");

			return _branchName;
		}

		_branchName = "master";

		return _branchName;
	}

	public GitWorkingDirectory getGitWorkingDirectory() {
		if (gitWorkingDirectory != null) {
			return gitWorkingDirectory;
		}

		checkGitRepositoryDir();

		gitWorkingDirectory = GitWorkingDirectoryFactory.newGitWorkingDirectory(
			getBranchName(),
			JenkinsResultsParserUtil.getCanonicalPath(gitRepositoryDir));

		return gitWorkingDirectory;
	}

	public void setGitRepositoryDir(File gitRepositoryDir) {
		if (this.gitRepositoryDir != null) {
			throw new IllegalStateException(
				"Repository directory is already set to " +
					this.gitRepositoryDir.getPath());
		}

		this.gitRepositoryDir = gitRepositoryDir;
	}

	protected GitRepositoryJob(String jobName) {
		super(jobName);
	}

	protected void checkGitRepositoryDir() {
		if (gitRepositoryDir == null) {
			throw new IllegalStateException("Repository directory is not set");
		}

		if (!gitRepositoryDir.exists()) {
			throw new IllegalStateException(
				gitRepositoryDir.getPath() + " does not exist");
		}
	}

	protected File gitRepositoryDir;
	protected GitWorkingDirectory gitWorkingDirectory;

	private static final Pattern _jobNamePattern = Pattern.compile(
		"[^\\(]+\\((?<branchName>[^\\)]+)\\)");

	private String _branchName;

}