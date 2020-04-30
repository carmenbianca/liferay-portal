/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class PortalTestSuiteUpstreamJob extends PortalAcceptancePullRequestJob {

	public PortalTestSuiteUpstreamJob(String jobName) {
		super(jobName, "default");
	}

	public PortalTestSuiteUpstreamJob(String jobName, String testSuiteName) {
		super(jobName, testSuiteName);
	}

}