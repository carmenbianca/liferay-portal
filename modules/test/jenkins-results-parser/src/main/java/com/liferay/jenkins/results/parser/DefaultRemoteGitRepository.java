/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class DefaultRemoteGitRepository extends BaseRemoteGitRepository {

	protected DefaultRemoteGitRepository(GitRemote gitRemote) {
		super(gitRemote);
	}

	protected DefaultRemoteGitRepository(
		String hostname, String gitRepositoryName, String username) {

		super(hostname, gitRepositoryName, username);
	}

}