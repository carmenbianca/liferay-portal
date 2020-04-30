/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public interface PortalWorkspace extends Workspace {

	public WorkspaceGitRepository getCompanionPortalWorkspaceGitRepository();

	public LegacyWorkspaceGitRepository getLegacyWorkspaceGitRepository();

	public WorkspaceGitRepository getOtherPortalWorkspaceGitRepository();

	public WorkspaceGitRepository getPluginsWorkspaceGitRepository();

	public PortalWorkspaceGitRepository
		getPrimaryPortalWorkspaceGitRepository();

}