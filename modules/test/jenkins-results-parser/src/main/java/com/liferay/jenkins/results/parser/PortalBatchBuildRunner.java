/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

/**
 * @author Michael Hashimoto
 */
public abstract class PortalBatchBuildRunner
	<T extends PortalBatchBuildData, S extends PortalWorkspace>
		extends BatchBuildRunner<T, S> {

	@Override
	public void run() {
		updateBuildDescription();

		setUpWorkspace();

		runTestBatch();

		publishArtifacts();

		updateBuildDescription();
	}

	protected PortalBatchBuildRunner(T portalBatchBuildData) {
		super(portalBatchBuildData);
	}

	@Override
	protected void initWorkspace() {
		PortalBatchBuildData portalBatchBuildData = getBuildData();

		Workspace batchWorkspace = WorkspaceFactory.newBatchWorkspace(
			portalBatchBuildData.getPortalGitHubURL(),
			portalBatchBuildData.getPortalUpstreamBranchName(),
			portalBatchBuildData.getBatchName(),
			portalBatchBuildData.getPortalBranchSHA());

		if (!(batchWorkspace instanceof PortalWorkspace)) {
			throw new RuntimeException("Invalid workspace");
		}

		setWorkspace((S)batchWorkspace);
	}

	protected void publishArtifacts() {
		PortalBatchBuildData portalBatchBuildData = getBuildData();

		File artifactDir = portalBatchBuildData.getArtifactDir();

		if (artifactDir.exists()) {
			publishToUserContentDir(artifactDir);
		}
	}

	protected void runTestBatch() {
		TestBatch testBatch = TestBatchFactory.newTestBatch(
			getBuildData(), getWorkspace());

		testBatch.run();
	}

}