/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class GitBranchFactory {

	public static LocalGitBranch newLocalGitBranch(
		LocalGitRepository localGitRepository, String name, String sha) {

		return new LocalGitBranch(localGitRepository, name, sha);
	}

	public static RemoteGitRef newRemoteGitRef(
		RemoteGitRepository remoteGitRepository, String name, String sha,
		String type) {

		if (type.equals("heads")) {
			return new RemoteGitBranch(remoteGitRepository, name, sha);
		}

		return new RemoteGitRef(remoteGitRepository, name, sha);
	}

}