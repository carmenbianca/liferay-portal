/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.Properties;

/**
 * @author Michael Hashimoto
 */
public class FunctionalBatchPortalWorkspace extends BatchPortalWorkspace {

	protected FunctionalBatchPortalWorkspace(
		String portalGitHubURL, String portalUpstreamBranchName,
		String portalBranchSHA) {

		super(portalGitHubURL, portalUpstreamBranchName, portalBranchSHA);

		_setPortalBuildProperties();
		_setPortalReleaseProperties();
	}

	@Override
	protected void setUpWorkspaceGitRepositories() {
		super.setUpWorkspaceGitRepositories();

		if (legacyWorkspaceGitRepository != null) {
			legacyWorkspaceGitRepository.setUp();
		}
	}

	@Override
	protected void tearDownWorkspaceGitRepositories() {
		super.tearDownWorkspaceGitRepositories();

		if (legacyWorkspaceGitRepository != null) {
			legacyWorkspaceGitRepository.tearDown();
		}
	}

	private void _setPortalBuildProperties() {
		Properties properties = new Properties();

		properties.put("jsp.precompile", "on");

		PortalWorkspaceGitRepository primaryPortalWorkspaceGitRepository =
			getPrimaryPortalWorkspaceGitRepository();

		primaryPortalWorkspaceGitRepository.setPortalBuildProperties(
			properties);
	}

	private void _setPortalReleaseProperties() {
		WorkspaceGitRepository pluginsWorkspaceGitRepository =
			getPluginsWorkspaceGitRepository();

		if (pluginsWorkspaceGitRepository == null) {
			return;
		}

		Properties properties = new Properties();

		properties.put(
			"lp.plugins.dir",
			String.valueOf(pluginsWorkspaceGitRepository.getDirectory()));

		PortalWorkspaceGitRepository primaryPortalWorkspaceGitRepository =
			getPrimaryPortalWorkspaceGitRepository();

		primaryPortalWorkspaceGitRepository.setPortalReleaseProperties(
			properties);
	}

}