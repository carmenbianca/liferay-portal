/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class PluginsWorkspaceGitRepository extends BaseWorkspaceGitRepository {

	public static final String TYPE = "plugins";

	@Override
	public String getType() {
		return TYPE;
	}

	protected PluginsWorkspaceGitRepository(JSONObject jsonObject) {
		super(jsonObject);
	}

	protected PluginsWorkspaceGitRepository(
		PullRequest pullRequest, String upstreamBranchName) {

		super(pullRequest, upstreamBranchName);
	}

	protected PluginsWorkspaceGitRepository(
		RemoteGitRef remoteGitRef, String upstreamBranchName) {

		super(remoteGitRef, upstreamBranchName);
	}

	@Override
	protected String getDefaultRelativeGitRepositoryDirPath(
		String upstreamBranchName) {

		String name = getName();

		if (upstreamBranchName.equals("master")) {
			return name.replace("-ee", "");
		}

		return JenkinsResultsParserUtil.combine(
			name.replace("-ee", ""), "-", upstreamBranchName);
	}

}