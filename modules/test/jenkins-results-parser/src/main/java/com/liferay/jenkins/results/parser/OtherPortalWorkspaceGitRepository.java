/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class OtherPortalWorkspaceGitRepository
	extends BasePortalWorkspaceGitRepository {

	public static final String TYPE = "portal.other";

	@Override
	public String getType() {
		return TYPE;
	}

	protected OtherPortalWorkspaceGitRepository(JSONObject jsonObject) {
		super(jsonObject);
	}

	protected OtherPortalWorkspaceGitRepository(
		PullRequest pullRequest, String upstreamBranchName) {

		super(pullRequest, upstreamBranchName);
	}

	protected OtherPortalWorkspaceGitRepository(
		RemoteGitRef remoteGitRef, String upstreamBranchName) {

		super(remoteGitRef, upstreamBranchName);
	}

}