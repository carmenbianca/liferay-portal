/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.Properties;
import java.util.Set;

/**
 * @author Yi-Chen Tsai
 */
public abstract class PortalAcceptanceTestSuiteJob
	extends PortalGitRepositoryJob implements TestSuiteJob {

	public PortalAcceptanceTestSuiteJob(String jobName) {
		this(jobName, "default");
	}

	public PortalAcceptanceTestSuiteJob(String jobName, String testSuiteName) {
		super(jobName);

		_testSuiteName = testSuiteName;
	}

	@Override
	public Set<String> getBatchNames() {
		Properties jobProperties = getJobProperties();

		String testBatchNames = JenkinsResultsParserUtil.getProperty(
			jobProperties, "test.batch.names[" + _testSuiteName + "]");

		if (testBatchNames == null) {
			testBatchNames = JenkinsResultsParserUtil.getProperty(
				jobProperties, "test.batch.names");
		}

		Set<String> testBatchNamesSet = getSetFromString(testBatchNames);

		if (!_testSuiteName.equals("relevant")) {
			return testBatchNamesSet;
		}

		String stableTestBatchNames = JenkinsResultsParserUtil.getProperty(
			jobProperties, "test.batch.names[stable]");

		if (stableTestBatchNames != null) {
			testBatchNamesSet.addAll(getSetFromString(stableTestBatchNames));
		}

		return testBatchNamesSet;
	}

	@Override
	public Set<String> getDistTypes() {
		Properties jobProperties = getJobProperties();

		String testBatchDistAppServers = JenkinsResultsParserUtil.getProperty(
			jobProperties,
			"test.batch.dist.app.servers[" + _testSuiteName + "]");

		if (testBatchDistAppServers == null) {
			testBatchDistAppServers = JenkinsResultsParserUtil.getProperty(
				jobProperties, "test.batch.dist.app.servers");
		}

		Set<String> testBatchDistAppServersSet = getSetFromString(
			testBatchDistAppServers);

		if (!_testSuiteName.equals("relevant")) {
			return testBatchDistAppServersSet;
		}

		String stableTestBatchDistAppServers =
			JenkinsResultsParserUtil.getProperty(
				jobProperties, "test.batch.dist.app.servers[stable]");

		if (stableTestBatchDistAppServers != null) {
			testBatchDistAppServersSet.addAll(
				getSetFromString(stableTestBatchDistAppServers));
		}

		return testBatchDistAppServersSet;
	}

	@Override
	public String getTestSuiteName() {
		return _testSuiteName;
	}

	private final String _testSuiteName;

}