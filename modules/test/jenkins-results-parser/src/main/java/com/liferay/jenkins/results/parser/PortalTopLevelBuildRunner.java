/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public abstract class PortalTopLevelBuildRunner
	<T extends PortalTopLevelBuildData, S extends PortalWorkspace>
		extends TopLevelBuildRunner<T, S> {

	protected PortalTopLevelBuildRunner(T portalTopLevelBuildData) {
		super(portalTopLevelBuildData);
	}

	@Override
	protected void initWorkspace() {
		T portalTopLevelBuildData = getBuildData();

		Workspace topLevelWorkspace = WorkspaceFactory.newTopLevelWorkspace(
			portalTopLevelBuildData.getPortalGitHubURL(),
			portalTopLevelBuildData.getPortalUpstreamBranchName());

		if (!(topLevelWorkspace instanceof PortalWorkspace)) {
			throw new RuntimeException("Invalid workspace");
		}

		if (JenkinsResultsParserUtil.isCINode()) {
			topLevelWorkspace.addJenkinsWorkspaceGitRepository(
				portalTopLevelBuildData.getJenkinsGitHubURL());
		}

		setWorkspace((S)topLevelWorkspace);
	}

}