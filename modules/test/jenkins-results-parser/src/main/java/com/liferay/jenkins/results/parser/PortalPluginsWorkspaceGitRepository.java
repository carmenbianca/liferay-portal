/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class PortalPluginsWorkspaceGitRepository
	extends PluginsWorkspaceGitRepository {

	public static final String TYPE = "portal.plugins";

	@Override
	public String getType() {
		return TYPE;
	}

	protected PortalPluginsWorkspaceGitRepository(JSONObject jsonObject) {
		super(jsonObject);
	}

	protected PortalPluginsWorkspaceGitRepository(
		PullRequest pullRequest, String upstreamBranchName) {

		super(pullRequest, upstreamBranchName);
	}

	protected PortalPluginsWorkspaceGitRepository(
		RemoteGitRef remoteGitRef, String upstreamBranchName) {

		super(remoteGitRef, upstreamBranchName);
	}

}