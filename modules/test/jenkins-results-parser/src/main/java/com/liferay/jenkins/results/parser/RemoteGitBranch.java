/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class RemoteGitBranch extends RemoteGitRef {

	protected RemoteGitBranch(
		RemoteGitRepository remoteGitRepository, String name, String sha) {

		super(remoteGitRepository, name, sha);
	}

}