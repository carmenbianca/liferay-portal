/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Peter Yoo
 */
public class ValidationGitHubMessageTest extends BuildTest {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		downloadSample(
			"test-portal-acceptance-pullrequest(7.0.x-private)" +
				"_validation-compile-failure",
			"94", "test-portal-acceptance-pullrequest(7.0.x-private)",
			"test-1-5");
		downloadSample(
			"test-portal-acceptance-pullrequest(7.0.x-private)" +
				"_validation-no-unit",
			"70", "test-portal-acceptance-pullrequest(7.0.x-private)",
			"test-1-13");
		downloadSample(
			"test-portal-acceptance-pullrequest(7.0.x-private)" +
				"_validation-unit-failure",
			"78", "test-portal-acceptance-pullrequest(7.0.x-private)",
			"test-1-10");
	}

	@Test
	public void testExpectedValidationMessage() throws Exception {
		expectedMessageGenerator = new ExpectedMessageGenerator() {

			@Override
			public String getMessage(TestSample testSample) throws Exception {
				TopLevelBuild topLevelBuild =
					(TopLevelBuild)BuildFactory.newBuildFromArchive(
						testSample.getSampleDirName());

				topLevelBuild.setCompareToUpstream(false);

				return Dom4JUtil.format(
					topLevelBuild.getValidationGitHubMessageElement(), true);
			}

		};

		assertSamples();
	}

	@Override
	protected File getExpectedMessageFile(TestSample testSample) {
		return new File(
			testSample.getSampleDir(), "expected-validation-message.html");
	}

}