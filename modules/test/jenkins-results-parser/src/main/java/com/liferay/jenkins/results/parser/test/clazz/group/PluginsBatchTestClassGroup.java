/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.GitWorkingDirectoryFactory;
import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.PluginsGitWorkingDirectory;
import com.liferay.jenkins.results.parser.PortalTestClassJob;

import java.io.File;
import java.io.IOException;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.Collections;
import java.util.Properties;

/**
 * @author Michael Hashimoto
 */
public class PluginsBatchTestClassGroup extends BatchTestClassGroup {

	@Override
	public int getAxisCount() {
		if (!isStableTestSuiteBatch() && testRelevantIntegrationUnitOnly) {
			return 0;
		}

		return super.getAxisCount();
	}

	public static class PluginsBatchTestClass extends BaseTestClass {

		protected static PluginsBatchTestClass getInstance(
			String batchName, File pluginDir) {

			return new PluginsBatchTestClass(
				batchName,
				new TestClassFile(
					JenkinsResultsParserUtil.getCanonicalPath(pluginDir)));
		}

		protected PluginsBatchTestClass(
			String batchName, TestClassFile testClassFile) {

			super(testClassFile);

			addTestClassMethod(batchName);
		}

	}

	protected PluginsBatchTestClassGroup(
		String batchName, BuildProfile buildProfile,
		PortalTestClassJob portalTestClassJob) {

		super(batchName, buildProfile, portalTestClassJob);

		Properties portalReleaseProperties =
			JenkinsResultsParserUtil.getProperties(
				new File(
					portalGitWorkingDirectory.getWorkingDirectory(),
					"release.properties"));

		_pluginsGitWorkingDirectory =
			(PluginsGitWorkingDirectory)
				GitWorkingDirectoryFactory.newGitWorkingDirectory(
					portalGitWorkingDirectory.getUpstreamBranchName(),
					JenkinsResultsParserUtil.getProperty(
						portalReleaseProperties, "lp.plugins.dir"));

		excludesPathMatchers.addAll(
			getPathMatchers(
				getFirstPropertyValue("test.batch.plugin.names.excludes"),
				_pluginsGitWorkingDirectory.getWorkingDirectory()));

		includesPathMatchers.addAll(
			getPathMatchers(
				getFirstPropertyValue("test.batch.plugin.names.includes"),
				_pluginsGitWorkingDirectory.getWorkingDirectory()));

		if (includeStableTestSuite && isStableTestSuiteBatch()) {
			excludesPathMatchers.addAll(
				getPathMatchers(
					getFirstPropertyValue(
						"test.batch.plugin.names.excludes", batchName,
						NAME_STABLE_TEST_SUITE),
					_pluginsGitWorkingDirectory.getWorkingDirectory()));

			includesPathMatchers.addAll(
				getPathMatchers(
					getFirstPropertyValue(
						"test.batch.plugin.names.includes", batchName,
						NAME_STABLE_TEST_SUITE),
					_pluginsGitWorkingDirectory.getWorkingDirectory()));
		}

		setTestClasses();

		setAxisTestClassGroups();
	}

	protected void setTestClasses() {
		File workingDirectory =
			_pluginsGitWorkingDirectory.getWorkingDirectory();

		try {
			Files.walkFileTree(
				workingDirectory.toPath(),
				new SimpleFileVisitor<Path>() {

					@Override
					public FileVisitResult preVisitDirectory(
							Path filePath, BasicFileAttributes attrs)
						throws IOException {

						if (JenkinsResultsParserUtil.isFileExcluded(
								excludesPathMatchers, filePath)) {

							return FileVisitResult.SKIP_SUBTREE;
						}

						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult visitFile(
							Path filePath, BasicFileAttributes attrs)
						throws IOException {

						if (JenkinsResultsParserUtil.isFileIncluded(
								excludesPathMatchers, includesPathMatchers,
								filePath)) {

							File file = filePath.toFile();

							testClasses.add(
								PluginsBatchTestClass.getInstance(
									batchName, file.getParentFile()));
						}

						return FileVisitResult.CONTINUE;
					}

				});
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				"Unable to search for test file names in " +
					workingDirectory.getPath(),
				ioException);
		}

		Collections.sort(testClasses);
	}

	private final PluginsGitWorkingDirectory _pluginsGitWorkingDirectory;

}