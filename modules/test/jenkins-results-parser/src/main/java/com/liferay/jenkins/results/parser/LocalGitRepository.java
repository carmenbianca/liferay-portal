/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.util.List;

/**
 * @author Peter Yoo
 */
public interface LocalGitRepository extends GitRepository {

	public static final Integer COMMITS_HISTORY_GROUP_SIZE = 100;

	public static final Integer COMMITS_HISTORY_SIZE_MAX = 25000;

	public File getDirectory();

	public GitWorkingDirectory getGitWorkingDirectory();

	public List<LocalGitCommit> getRangeLocalGitCommits(
		String earliestSHA, String latestSHA);

	public String getUpstreamBranchName();

}