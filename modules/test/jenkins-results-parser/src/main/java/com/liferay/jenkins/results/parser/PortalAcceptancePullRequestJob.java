/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Michael Hashimoto
 */
public class PortalAcceptancePullRequestJob
	extends PortalAcceptanceTestSuiteJob {

	public PortalAcceptancePullRequestJob(String jobName) {
		this(jobName, "default");
	}

	public PortalAcceptancePullRequestJob(
		String jobName, String testSuiteName) {

		super(jobName, testSuiteName);
	}

	@Override
	public Set<String> getBatchNames() {
		Set<String> testBatchNamesSet = super.getBatchNames();

		if (_isRelevantTestSuite() && _isPortalWebOnly()) {
			String[] portalWebOnlyBatchNameMarkers = {
				"compile-jsp", "functional", "portal-web", "source-format"
			};

			Set<String> portalWebOnlyBatchNamesSet = new TreeSet<>();

			for (String testBatchName : testBatchNamesSet) {
				for (String portalWebOnlyBatchNameMarker :
						portalWebOnlyBatchNameMarkers) {

					if (testBatchName.contains(portalWebOnlyBatchNameMarker)) {
						portalWebOnlyBatchNamesSet.add(testBatchName);

						break;
					}
				}
			}

			return portalWebOnlyBatchNamesSet;
		}

		return testBatchNamesSet;
	}

	private boolean _isPortalWebOnly() {
		GitWorkingDirectory gitWorkingDirectory = getGitWorkingDirectory();

		File portalWebDirectory = new File(
			gitWorkingDirectory.getWorkingDirectory(), "portal-web");

		for (File modifiedFile : gitWorkingDirectory.getModifiedFilesList()) {
			if (!JenkinsResultsParserUtil.isFileInDirectory(
					portalWebDirectory, modifiedFile)) {

				return false;
			}
		}

		return true;
	}

	private boolean _isRelevantTestSuite() {
		String testSuiteName = getTestSuiteName();

		return testSuiteName.equals("relevant");
	}

}