/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class BuildDataFactory {

	public static BatchBuildData newBatchBuildData(
		String runID, String jobName, String buildURL) {

		if (jobName.contains("portal") ||
			jobName.contains("root-cause-analysis-tool")) {

			return new PortalBatchBuildData(runID, jobName, buildURL);
		}

		return new DefaultBatchBuildData(runID, jobName, buildURL);
	}

	public static BuildData newBuildData(
		String runID, String jobName, String buildURL) {

		if (jobName.endsWith("-batch")) {
			return newBatchBuildData(runID, jobName, buildURL);
		}

		return newTopLevelBuildData(runID, jobName, buildURL);
	}

	public static TopLevelBuildData newTopLevelBuildData(
		String runID, String jobName, String buildURL) {

		if (jobName.contains("test-portal-testsuite-upstream-controller")) {
			return new PortalTestSuiteUpstreamControllerBuildData(
				runID, jobName, buildURL);
		}
		else if (jobName.contains("portal") ||
				 jobName.contains("root-cause-analysis-tool")) {

			return new PortalTopLevelBuildData(runID, jobName, buildURL);
		}

		return new DefaultTopLevelBuildData(runID, jobName, buildURL);
	}

}