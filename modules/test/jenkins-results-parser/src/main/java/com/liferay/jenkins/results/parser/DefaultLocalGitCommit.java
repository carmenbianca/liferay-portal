/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class DefaultLocalGitCommit extends BaseLocalGitCommit {

	protected DefaultLocalGitCommit(
		GitWorkingDirectory gitWorkingDirectory, String message, String sha,
		GitCommit.Type type, long commitTime) {

		super(gitWorkingDirectory, message, sha, type, commitTime);
	}

}