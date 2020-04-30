/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.Properties;

/**
 * @author Michael Hashimoto
 */
public class JunitBatchPortalWorkspace extends BatchPortalWorkspace {

	protected JunitBatchPortalWorkspace(
		String portalGitHubURL, String portalUpstreamBranchName,
		String portalBranchSHA) {

		super(portalGitHubURL, portalUpstreamBranchName, portalBranchSHA);

		_setPortalBuildProperties();
	}

	private void _setPortalBuildProperties() {
		WorkspaceGitRepository otherPortalWorkspaceGitRepository =
			getOtherPortalWorkspaceGitRepository();

		if (otherPortalWorkspaceGitRepository == null) {
			return;
		}

		Properties properties = new Properties();

		properties.put(
			"release.versions.test.other.dir",
			String.valueOf(otherPortalWorkspaceGitRepository.getDirectory()));

		PortalWorkspaceGitRepository primaryPortalWorkspaceGitRepository =
			getPrimaryPortalWorkspaceGitRepository();

		primaryPortalWorkspaceGitRepository.setPortalBuildProperties(
			properties);
	}

}