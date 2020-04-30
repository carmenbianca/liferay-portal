/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

/**
 * @author Michael Hashimoto
 */
public class RootCauseAnalysisToolBatchJob extends RootCauseAnalysisToolJob {

	public RootCauseAnalysisToolBatchJob(
		String jobName, String portalBranchName) {

		super(jobName, portalBranchName);

		GitWorkingDirectory jenkinsGitWorkingDirectory =
			getJenkinsGitWorkingDirectory();

		jobPropertiesFiles.add(
			new File(
				jenkinsGitWorkingDirectory.getWorkingDirectory(),
				JenkinsResultsParserUtil.combine(
					"commands/dependencies/",
					"root-cause-analysis-tool-batch.properties")));

		PortalGitWorkingDirectory portalGitWorkingDirectory =
			getPortalGitWorkingDirectory();

		jobPropertiesFiles.add(
			new File(
				portalGitWorkingDirectory.getWorkingDirectory(),
				"test.properties"));

		readJobProperties();
	}

}