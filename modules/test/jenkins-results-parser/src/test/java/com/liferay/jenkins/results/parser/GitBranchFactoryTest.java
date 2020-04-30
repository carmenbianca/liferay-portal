/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.junit.Test;

/**
 * @author Michael Hashimoto
 */
public class GitBranchFactoryTest extends GitRefTest {

	@Test
	public void testNewLocalGitBranch() {
		LocalGitRepository localGitRepository = _getLocalGitRepository();

		LocalGitBranch localGitBranch = GitBranchFactory.newLocalGitBranch(
			localGitRepository, NAME_REF, SHA_REF);

		if (localGitBranch == null) {
			errorCollector.addError(new Throwable("Local Git branch is null"));
		}
	}

	private LocalGitRepository _getLocalGitRepository() {
		return GitRepositoryFactory.getLocalGitRepository(
			NAME_REPOSITORY, NAME_REPOSITORY_UPSTREAM_BRANCH);
	}

}