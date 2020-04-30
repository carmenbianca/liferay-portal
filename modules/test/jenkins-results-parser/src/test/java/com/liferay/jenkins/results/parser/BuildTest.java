/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;

import java.net.URL;

import java.util.Hashtable;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;

/**
 * @author Peter Yoo
 */
public class BuildTest extends Test {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		JenkinsResultsParserUtil.setBuildProperties(
			JenkinsResultsParserUtil.getBuildProperties());

		downloadSample(
			"test-portal-acceptance-pullrequest(7.0.x-private)" +
				"_validation-passed",
			"77", "test-portal-acceptance-pullrequest(7.0.x-private)",
			"test-1-10");
	}

	@After
	public void tearDown() {
		JenkinsResultsParserUtil.setBuildProperties(
			(Hashtable<Object, Object>)null);
	}

	@Override
	protected void downloadSample(TestSample testSample, URL url) {
		Build build = BuildFactory.newBuild(
			JenkinsResultsParserUtil.getLocalURL(url.toExternalForm()), null);

		build.archive(testSample.getSampleDirName());
	}

	protected Properties loadProperties(String sampleName) throws Exception {
		Properties properties = new Properties();

		TestSample testSample = testSamples.get(sampleName);

		String content = JenkinsResultsParserUtil.toString(
			JenkinsResultsParserUtil.getLocalURL(
				toURLString(
					new File(testSample.getSampleDir(), "sample.properties"))));

		properties.load(new StringReader(content));

		return properties;
	}

	protected void saveProperties(File file, Properties properties)
		throws Exception {

		try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
			properties.store(fileOutputStream, null);
		}
	}

}