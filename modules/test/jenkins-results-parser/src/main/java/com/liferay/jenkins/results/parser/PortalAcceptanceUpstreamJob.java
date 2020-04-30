/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class PortalAcceptanceUpstreamJob extends PortalAcceptanceTestSuiteJob {

	public PortalAcceptanceUpstreamJob(String jobName) {
		super(jobName);
	}

	public PortalAcceptanceUpstreamJob(String jobName, String testSuite) {
		super(jobName, testSuite);
	}

}