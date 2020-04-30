/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class JenkinsWorkspaceGitRepository extends BaseWorkspaceGitRepository {

	public static final String TYPE = "jenkins";

	@Override
	public String getType() {
		return TYPE;
	}

	protected JenkinsWorkspaceGitRepository(JSONObject jsonObject) {
		super(jsonObject);
	}

	protected JenkinsWorkspaceGitRepository(
		PullRequest pullRequest, String upstreamBranchName) {

		super(pullRequest, upstreamBranchName);
	}

	protected JenkinsWorkspaceGitRepository(
		RemoteGitRef remoteGitRef, String upstreamBranchName) {

		super(remoteGitRef, upstreamBranchName);
	}

}