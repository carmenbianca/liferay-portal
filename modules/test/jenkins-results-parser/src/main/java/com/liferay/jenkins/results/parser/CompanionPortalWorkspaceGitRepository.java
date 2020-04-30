/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.IOException;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class CompanionPortalWorkspaceGitRepository
	extends BasePortalWorkspaceGitRepository {

	public static final String TYPE = "portal.companion";

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public void setUp() {
		super.setUp();

		String parentUpstreamBranchName =
			_parentWorkspaceGitRepository.getUpstreamBranchName();

		if (parentUpstreamBranchName.contains("-private")) {
			try {
				JenkinsResultsParserUtil.write(
					new File(
						_parentWorkspaceGitRepository.getDirectory(),
						"git-commit-portal"),
					getBranchSHA());
			}
			catch (IOException ioException) {
				throw new RuntimeException(ioException);
			}

			try {
				AntUtil.callTarget(
					_parentWorkspaceGitRepository.getDirectory(),
					"build-working-dir.xml", "prepare-working-dir");
			}
			catch (AntException antException) {
				throw new RuntimeException(antException);
			}

			return;
		}

		File modulesPrivateDir = new File(getDirectory(), "modules/private");

		if (!modulesPrivateDir.exists()) {
			return;
		}

		File parentModulesPrivateDir = new File(
			_parentWorkspaceGitRepository.getDirectory(), "modules/private");

		try {
			JenkinsResultsParserUtil.copy(
				modulesPrivateDir, parentModulesPrivateDir);
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	protected CompanionPortalWorkspaceGitRepository(JSONObject jsonObject) {
		super(jsonObject);

		BuildDatabase buildDatabase = BuildDatabaseUtil.getBuildDatabase();

		_parentWorkspaceGitRepository = buildDatabase.getWorkspaceGitRepository(
			PrimaryPortalWorkspaceGitRepository.TYPE);
	}

	protected CompanionPortalWorkspaceGitRepository(
		PullRequest pullRequest, String upstreamBranchName,
		WorkspaceGitRepository parentWorkspaceGitRepository) {

		super(pullRequest, upstreamBranchName);

		_parentWorkspaceGitRepository = parentWorkspaceGitRepository;
	}

	protected CompanionPortalWorkspaceGitRepository(
		RemoteGitRef remoteGitRef, String upstreamBranchName,
		WorkspaceGitRepository parentWorkspaceGitRepository) {

		super(remoteGitRef, upstreamBranchName);

		_parentWorkspaceGitRepository = parentWorkspaceGitRepository;
	}

	private final WorkspaceGitRepository _parentWorkspaceGitRepository;

}