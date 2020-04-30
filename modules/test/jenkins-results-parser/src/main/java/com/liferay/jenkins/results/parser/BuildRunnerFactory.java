/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.lang.reflect.Proxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michael Hashimoto
 */
public class BuildRunnerFactory {

	public static BuildRunner<?, ?> newBuildRunner(BuildData buildData) {
		String jobName = buildData.getJobName();

		BuildRunner<?, ?> buildRunner = null;

		if (jobName.equals("root-cause-analysis-tool")) {
			buildRunner = new RootCauseAnalysisToolTopLevelBuildRunner(
				(PortalTopLevelBuildData)buildData);
		}

		if (jobName.contains("-batch")) {
			buildRunner = new DefaultPortalBatchBuildRunner(
				(PortalBatchBuildData)buildData);
		}

		if (jobName.startsWith("test-portal-testsuite-upstream-controller(")) {
			Matcher matcher = _jobNamePattern.matcher(jobName);

			if (matcher.find() && (matcher.group("testSuiteName") != null)) {
				buildRunner =
					new PortalTestSuiteUpstreamControllerSingleSuiteBuildRunner(
						(PortalTestSuiteUpstreamControllerBuildData)buildData);
			}
			else {
				buildRunner = new PortalTestSuiteUpstreamControllerBuildRunner(
					(PortalTestSuiteUpstreamControllerBuildData)buildData);
			}
		}

		if (buildRunner == null) {
			throw new RuntimeException("Invalid build data " + buildData);
		}

		return (BuildRunner<?, ?>)Proxy.newProxyInstance(
			BuildRunner.class.getClassLoader(),
			new Class<?>[] {BuildRunner.class}, new MethodLogger(buildRunner));
	}

	private static final Pattern _jobNamePattern = Pattern.compile(
		"[^\\(]+\\((?<upstreamBranchName>[^_]+)" +
			"(_(?<testSuiteName>[^\\)]+))?\\)");

}