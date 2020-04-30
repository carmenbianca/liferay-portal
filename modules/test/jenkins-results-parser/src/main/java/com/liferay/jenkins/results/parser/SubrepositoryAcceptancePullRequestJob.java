/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.Properties;
import java.util.Set;

/**
 * @author Michael Hashimoto
 */
public class SubrepositoryAcceptancePullRequestJob
	extends SubrepositoryGitRepositoryJob implements TestSuiteJob {

	public SubrepositoryAcceptancePullRequestJob(
		String jobName, String testSuiteName, String repositoryName) {

		super(jobName, repositoryName);

		_testSuiteName = testSuiteName;

		_setTestRunValidation();
	}

	@Override
	public Set<String> getBatchNames() {
		String testBatchNames = JenkinsResultsParserUtil.getProperty(
			getJobProperties(), "test.batch.names[" + _testSuiteName + "]");

		if (testBatchNames == null) {
			return super.getBatchNames();
		}

		return getSetFromString(testBatchNames);
	}

	@Override
	public Set<String> getDistTypes() {
		Properties jobProperties = getJobProperties();

		String testBatchDistAppServers = JenkinsResultsParserUtil.getProperty(
			jobProperties, "subrepo.dist.app.servers[" + _testSuiteName + "]");

		if (testBatchDistAppServers == null) {
			testBatchDistAppServers = JenkinsResultsParserUtil.getProperty(
				jobProperties, "subrepo.dist.app.servers");
		}

		return getSetFromString(testBatchDistAppServers);
	}

	@Override
	public String getTestSuiteName() {
		return _testSuiteName;
	}

	private void _setTestRunValidation() {
		Properties jobProperties = getJobProperties();

		String testRunValidationProperty = JenkinsResultsParserUtil.getProperty(
			jobProperties, "test.run.validation[" + _testSuiteName + "]");

		if (testRunValidationProperty == null) {
			testRunValidationProperty = JenkinsResultsParserUtil.getProperty(
				jobProperties, "test.run.validation");
		}

		testRunValidation = Boolean.parseBoolean(testRunValidationProperty);
	}

	private final String _testSuiteName;

}