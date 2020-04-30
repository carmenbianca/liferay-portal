/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

/**
 * @author Michael Hashimoto
 */
public class PortalFixpackReleaseJob extends BasePortalReleaseJob {

	public PortalFixpackReleaseJob(String jobName, String portalBranchName) {
		super(jobName, portalBranchName);

		GitWorkingDirectory jenkinsGitWorkingDirectory =
			getJenkinsGitWorkingDirectory();

		jobPropertiesFiles.add(
			new File(
				jenkinsGitWorkingDirectory.getWorkingDirectory(),
				"commands/dependencies" +
					"/test-portal-fixpack-release.properties"));

		readJobProperties();
	}

}