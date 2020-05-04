/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class DefaultLocalGitRepository extends BaseLocalGitRepository {

	protected DefaultLocalGitRepository(
		String name, String upstreamBranchName) {

		super(name, upstreamBranchName);
	}

}