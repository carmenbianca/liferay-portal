/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class LegacyWorkspaceGitRepository extends BaseWorkspaceGitRepository {

	public static final String TYPE = "legacy";

	@Override
	public String getType() {
		return TYPE;
	}

	protected LegacyWorkspaceGitRepository(JSONObject jsonObject) {
		super(jsonObject);
	}

	protected LegacyWorkspaceGitRepository(
		PullRequest pullRequest, String upstreamBranchName) {

		super(pullRequest, upstreamBranchName);
	}

	protected LegacyWorkspaceGitRepository(
		RemoteGitRef remoteGitRef, String upstreamBranchName) {

		super(remoteGitRef, upstreamBranchName);
	}

}