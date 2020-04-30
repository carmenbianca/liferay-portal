/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import com.liferay.jenkins.results.parser.util.TestPropertiesUtil;
import com.liferay.jenkins.results.parser.util.TestPropertiesValues;

import java.util.Properties;

import org.junit.BeforeClass;

/**
 * @author Michael Hashimoto
 */
public class GitRepositoryTest extends Test {

	@BeforeClass
	public static void setUpClass() {
		TestPropertiesUtil.printProperties();

		Properties repositoryProperties = new Properties();

		repositoryProperties.put(
			JenkinsResultsParserUtil.combine(
				"repository.dir[", NAME_REPOSITORY, "][",
				NAME_REPOSITORY_UPSTREAM_BRANCH, "]"),
			FILE_PATH_REPOSITORY);

		BaseGitRepository.setRepositoryProperties(repositoryProperties);
	}

	protected static final String FILE_PATH_REPOSITORY =
		TestPropertiesValues.FILE_PATH_REPOSITORY;

	protected static final String HOSTNAME_REPOSITORY =
		TestPropertiesValues.HOSTNAME_REPOSITORY;

	protected static final String NAME_REPOSITORY =
		TestPropertiesValues.NAME_REPOSITORY;

	protected static final String NAME_REPOSITORY_UPSTREAM_BRANCH =
		TestPropertiesValues.NAME_REPOSITORY_UPSTREAM_BRANCH;

	protected static final String USERNAME_REPOSITORY =
		TestPropertiesValues.USERNAME_REPOSITORY;

}