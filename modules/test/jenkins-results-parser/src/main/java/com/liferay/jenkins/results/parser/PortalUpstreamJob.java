/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.util.Set;

/**
 * @author Leslie Wong
 */
public class PortalUpstreamJob
	extends PortalGitRepositoryJob implements BatchDependentJob {

	public PortalUpstreamJob(String jobName) {
		super(jobName);

		GitWorkingDirectory jenkinsGitWorkingDirectory =
			GitWorkingDirectoryFactory.newJenkinsGitWorkingDirectory();

		jobPropertiesFiles.add(
			new File(
				jenkinsGitWorkingDirectory.getWorkingDirectory(),
				"commands/dependencies/test-upstream-batch.properties"));

		readJobProperties();
	}

	@Override
	public Set<String> getBatchNames() {
		String testBatchNames = JenkinsResultsParserUtil.getProperty(
			getJobProperties(),
			"test.batch.names[portal-upstream(" + getBranchName() + ")]");

		return getSetFromString(testBatchNames);
	}

	@Override
	public Set<String> getDependentBatchNames() {
		String testBatchNames = JenkinsResultsParserUtil.getProperty(
			getJobProperties(),
			"test.batch.names.smoke[" + getBranchName() + "]");

		return getSetFromString(testBatchNames);
	}

}