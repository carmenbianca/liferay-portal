/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseLocalGitCommit
	extends BaseGitCommit implements LocalGitCommit {

	@Override
	public GitWorkingDirectory getGitWorkingDirectory() {
		return _gitWorkingDirectory;
	}

	protected BaseLocalGitCommit(
		GitWorkingDirectory gitWorkingDirectory, String message, String sha,
		GitCommit.Type type, long commitTime) {

		super(
			gitWorkingDirectory.getGitRepositoryName(), message, sha, type,
			commitTime);

		_gitWorkingDirectory = gitWorkingDirectory;
	}

	private final GitWorkingDirectory _gitWorkingDirectory;

}