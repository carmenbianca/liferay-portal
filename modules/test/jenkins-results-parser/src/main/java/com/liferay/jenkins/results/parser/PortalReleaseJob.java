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
public class PortalReleaseJob extends BasePortalReleaseJob {

	public PortalReleaseJob(String jobName, String portalBranchName) {
		super(jobName, portalBranchName);

		GitWorkingDirectory jenkinsGitWorkingDirectory =
			getJenkinsGitWorkingDirectory();

		jobPropertiesFiles.add(
			new File(
				jenkinsGitWorkingDirectory.getWorkingDirectory(),
				"commands/dependencies/test-portal-release.properties"));

		readJobProperties();
	}

	@Override
	public Set<String> getBatchNames() {
		Set<String> testBatchNames = super.getBatchNames();

		testBatchNames.addAll(_getOptionalBatchNames());

		return testBatchNames;
	}

	public void setPortalReleaseRef(String portalReleaseRef) {
		_portalReleaseRef = portalReleaseRef;
	}

	private Set<String> _getOptionalBatchNames() {
		if (_portalReleaseRef == null) {
			return Collections.emptySet();
		}

		String testBatchNamesString = JenkinsResultsParserUtil.getProperty(
			getJobProperties(),
			"test.batch.names.optional[" + _portalReleaseRef + "]");

		return getSetFromString(testBatchNamesString);
	}

	private String _portalReleaseRef;

}