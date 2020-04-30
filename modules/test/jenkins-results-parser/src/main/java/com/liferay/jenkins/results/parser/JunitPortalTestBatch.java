/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public class JunitPortalTestBatch
	extends BasePortalTestBatch<PortalBatchBuildData, PortalWorkspace> {

	protected JunitPortalTestBatch(
		PortalBatchBuildData portalBatchBuildData,
		PortalWorkspace portalWorkspace) {

		super(portalBatchBuildData, portalWorkspace);
	}

	@Override
	protected void executeBatch() throws AntException {
		PortalBatchBuildData portalBatchBuildData = getBatchBuildData();

		Map<String, String> buildParameters = new HashMap<>();

		buildParameters.put("axis.variable", "0");
		buildParameters.put(
			"test.batch.name", portalBatchBuildData.getBatchName());
		buildParameters.put("test.batch.size", "1");

		Map<String, String> environmentVariables = new HashMap<>();

		if (JenkinsResultsParserUtil.isCINode()) {
			String batchName = portalBatchBuildData.getBatchName();

			environmentVariables.put("ANT_OPTS", getAntOpts(batchName));
			environmentVariables.put("JAVA_HOME", getJavaHome(batchName));
			environmentVariables.put("PATH", getPath(batchName));

			environmentVariables.put(
				"TOP_LEVEL_JOB_NAME",
				portalBatchBuildData.getTopLevelJobName());
		}

		AntUtil.callTarget(
			getPrimaryPortalWorkspaceDirectory(), "build-test-batch.xml",
			portalBatchBuildData.getBatchName(), buildParameters,
			environmentVariables);
	}

}