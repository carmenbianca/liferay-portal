/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public abstract class BasePortalTestBatch
	<T extends PortalBatchBuildData, S extends PortalWorkspace>
		extends BaseTestBatch<T, S> {

	protected BasePortalTestBatch(T batchBuildData, S workspace) {
		super(batchBuildData, workspace);
	}

	@Override
	protected void executeBatch() throws AntException {
		BatchBuildData batchBuildData = getBatchBuildData();

		Map<String, String> buildParameters = new HashMap<>();

		buildParameters.put(
			"axis.variable",
			JenkinsResultsParserUtil.join(",", batchBuildData.getTestList()));
		buildParameters.put("test.batch.name", batchBuildData.getBatchName());

		Map<String, String> environmentVariables = new HashMap<>();

		if (JenkinsResultsParserUtil.isCINode()) {
			String batchName = batchBuildData.getBatchName();

			environmentVariables.put("ANT_OPTS", getAntOpts(batchName));
			environmentVariables.put("JAVA_HOME", getJavaHome(batchName));
			environmentVariables.put("PATH", getPath(batchName));
		}

		AntUtil.callTarget(
			getPrimaryPortalWorkspaceDirectory(), "build-test-batch.xml",
			batchBuildData.getBatchName(), buildParameters,
			environmentVariables);
	}

	@Override
	protected T getBatchBuildData() {
		return super.getBatchBuildData();
	}

	protected File getPrimaryPortalWorkspaceDirectory() {
		PortalWorkspace portalWorkspace = getWorkspace();

		WorkspaceGitRepository workspaceGitRepository =
			portalWorkspace.getPrimaryPortalWorkspaceGitRepository();

		return workspaceGitRepository.getDirectory();
	}

	@Override
	protected void publishResults() {
		try {
			AntUtil.callTarget(
				getPrimaryPortalWorkspaceDirectory(), "build-test.xml",
				"merge-test-results");
		}
		catch (AntException antException) {
			throw new RuntimeException(antException);
		}

		File sourceFile = new File(
			getPrimaryPortalWorkspaceDirectory(),
			"test-results/TESTS-TestSuites.xml");

		if (!sourceFile.exists()) {
			return;
		}

		BatchBuildData batchBuildData = getBatchBuildData();

		File targetFile = new File(
			batchBuildData.getWorkspaceDir(),
			"test-results/TESTS-TestSuites.xml");

		try {
			JenkinsResultsParserUtil.copy(sourceFile, targetFile);
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				JenkinsResultsParserUtil.combine(
					"Unable to copy test results file from ",
					sourceFile.getPath(), " to ", targetFile.getPath()),
				ioException);
		}
	}

}