/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.List;
import java.util.Properties;

/**
 * @author Michael Hashimoto
 */
public interface WorkspaceGitRepository extends LocalGitRepository {

	public String getFileContent(String filePath);

	public String getGitHubDevBranchName();

	public String getGitHubURL();

	public List<LocalGitCommit> getHistoricalLocalGitCommits();

	public String getType();

	public Properties getWorkspaceJobProperties(String propertyType, Job job);

	public List<List<LocalGitCommit>> partitionLocalGitCommits(
		List<LocalGitCommit> localGitCommits, int count);

	public void setBranchSHA(String branchSHA);

	public void setUp();

	public void storeCommitHistory(List<String> commitSHAs);

	public void tearDown();

	public void writePropertiesFiles();

}