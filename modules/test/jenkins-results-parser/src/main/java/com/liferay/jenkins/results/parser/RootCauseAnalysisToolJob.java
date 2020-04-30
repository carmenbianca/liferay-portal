/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.util.Collections;
import java.util.Set;

/**
 * @author Michael Hashimoto
 */
public class RootCauseAnalysisToolJob
	extends BaseJob implements PortalTestClassJob {

	public RootCauseAnalysisToolJob(String jobName, String portalBranchName) {
		super(jobName);

		_jenkinsGitWorkingDirectory =
			GitWorkingDirectoryFactory.newJenkinsGitWorkingDirectory();

		_portalGitWorkingDirectory =
			GitWorkingDirectoryFactory.newPortalGitWorkingDirectory(
				portalBranchName);

		jobPropertiesFiles.add(
			new File(
				_jenkinsGitWorkingDirectory.getWorkingDirectory(),
				"commands/build.properties"));

		jobPropertiesFiles.add(
			new File(
				_jenkinsGitWorkingDirectory.getWorkingDirectory(),
				"commands/dependencies/root-cause-analysis-tool.properties"));

		jobPropertiesFiles.add(
			new File(
				_portalGitWorkingDirectory.getWorkingDirectory(),
				"test.properties"));

		readJobProperties();
	}

	@Override
	public Set<String> getBatchNames() {
		String testBatchNames = JenkinsResultsParserUtil.getProperty(
			getJobProperties(), "test.batch.names");

		return getSetFromString(testBatchNames);
	}

	@Override
	public Set<String> getDistTypes() {
		return Collections.emptySet();
	}

	public GitWorkingDirectory getJenkinsGitWorkingDirectory() {
		return _jenkinsGitWorkingDirectory;
	}

	@Override
	public PortalGitWorkingDirectory getPortalGitWorkingDirectory() {
		return _portalGitWorkingDirectory;
	}

	private final GitWorkingDirectory _jenkinsGitWorkingDirectory;
	private final PortalGitWorkingDirectory _portalGitWorkingDirectory;

}