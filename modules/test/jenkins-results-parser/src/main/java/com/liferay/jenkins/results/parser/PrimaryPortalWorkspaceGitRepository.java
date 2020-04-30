/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class PrimaryPortalWorkspaceGitRepository
	extends BasePortalWorkspaceGitRepository {

	public static final String TYPE = "portal";

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public void setUp() {
		super.setUp();

		String upstreamBranchName = getUpstreamBranchName();

		if (!upstreamBranchName.startsWith("ee-") &&
			!upstreamBranchName.endsWith("-private")) {

			_setupProfileDXP();
		}
	}

	protected PrimaryPortalWorkspaceGitRepository(JSONObject jsonObject) {
		super(jsonObject);
	}

	protected PrimaryPortalWorkspaceGitRepository(
		PullRequest pullRequest, String upstreamBranchName) {

		super(pullRequest, upstreamBranchName);
	}

	protected PrimaryPortalWorkspaceGitRepository(
		RemoteGitRef remoteGitRef, String upstreamBranchName) {

		super(remoteGitRef, upstreamBranchName);
	}

	private void _setupProfileDXP() {
		try {
			AntUtil.callTarget(
				getDirectory(), "build.xml", "setup-profile-dxp");
		}
		catch (AntException antException) {
			throw new RuntimeException(
				"Unable to set up DXP profile", antException);
		}
	}

}