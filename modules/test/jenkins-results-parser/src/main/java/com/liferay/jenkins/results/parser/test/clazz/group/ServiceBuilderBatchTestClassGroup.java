/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.PortalGitWorkingDirectory;
import com.liferay.jenkins.results.parser.PortalTestClassJob;

import java.io.File;
import java.io.IOException;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Chen Tsai
 */
public class ServiceBuilderBatchTestClassGroup
	extends ModulesBatchTestClassGroup {

	@Override
	public int getAxisCount() {
		if (!isStableTestSuiteBatch() && testRelevantIntegrationUnitOnly) {
			return 0;
		}

		if ((_buildType == BuildType.FULL) ||
			(testClasses.isEmpty() && (_buildType == BuildType.CORE))) {

			return 1;
		}

		return super.getAxisCount();
	}

	public BuildType getBuildType() {
		return _buildType;
	}

	public static enum BuildType {

		CORE, FULL

	}

	public static class ServiceBuilderBatchTestClass
		extends ModulesBatchTestClass {

		protected static ServiceBuilderBatchTestClass getInstance(
			File moduleBaseDir, File modulesDir,
			List<File> modulesProjectDirs) {

			return new ServiceBuilderBatchTestClass(
				new TestClassFile(
					JenkinsResultsParserUtil.getCanonicalPath(moduleBaseDir)),
				modulesDir, modulesProjectDirs);
		}

		protected ServiceBuilderBatchTestClass(
			TestClassFile testClassFile, File modulesDir,
			List<File> modulesProjectDirs) {

			super(testClassFile);

			initTestClassMethods(
				modulesProjectDirs, modulesDir, "buildService");
		}

	}

	protected static List<File> getModulesProjectDirs(File moduleBaseDir) {
		final List<File> modulesProjectDirs = new ArrayList<>();
		final Path moduleBaseDirPath = moduleBaseDir.toPath();

		try {
			Files.walkFileTree(
				moduleBaseDirPath,
				new SimpleFileVisitor<Path>() {

					@Override
					public FileVisitResult preVisitDirectory(
						Path filePath, BasicFileAttributes attrs) {

						File currentDirectory = filePath.toFile();
						String filePathString = filePath.toString();

						if (filePathString.endsWith("-service")) {
							File buildFile = new File(
								currentDirectory, "build.gradle");
							File serviceXmlFile = new File(
								currentDirectory, "service.xml");

							if (buildFile.exists() && serviceXmlFile.exists()) {
								modulesProjectDirs.add(currentDirectory);

								return FileVisitResult.SKIP_SUBTREE;
							}
						}
						else if (filePathString.endsWith("-portlet")) {
							File portletXmlFile = new File(
								currentDirectory,
								"docroot/WEB-INF/portlet.xml");
							File serviceXmlFile = new File(
								currentDirectory,
								"docroot/WEB-INF/service.xml");

							if (portletXmlFile.exists() &&
								serviceXmlFile.exists()) {

								modulesProjectDirs.add(currentDirectory);

								return FileVisitResult.SKIP_SUBTREE;
							}
						}

						return FileVisitResult.CONTINUE;
					}

				});
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				"Unable to get module marker files from " +
					moduleBaseDir.getPath(),
				ioException);
		}

		return modulesProjectDirs;
	}

	protected ServiceBuilderBatchTestClassGroup(
		String batchName, BuildProfile buildProfile,
		PortalTestClassJob portalTestClassJob) {

		super(batchName, buildProfile, portalTestClassJob);
	}

	@Override
	protected void setAxisTestClassGroups() {
		int testClassCount = testClasses.size();

		int axisCount = getAxisCount();

		if ((testClassCount == 0) && (axisCount == 1)) {
			axisTestClassGroups.put(0, new AxisTestClassGroup(this, 0));

			return;
		}

		super.setAxisTestClassGroups();
	}

	@Override
	protected void setTestClasses() throws IOException {
		PortalGitWorkingDirectory portalGitWorkingDirectory =
			getPortalGitWorkingDirectory();

		File portalModulesBaseDir = new File(
			portalGitWorkingDirectory.getWorkingDirectory(), "modules");

		if (testRelevantChanges &&
			!(includeStableTestSuite && isStableTestSuiteBatch())) {

			List<File> modifiedFiles =
				portalGitWorkingDirectory.getModifiedFilesList();

			List<File> modifiedPortalToolsServiceBuilderFiles =
				JenkinsResultsParserUtil.getIncludedFiles(
					null,
					getPathMatchers(
						"util/portal-tools-service-builder/**",
						portalModulesBaseDir),
					modifiedFiles);

			if (!modifiedPortalToolsServiceBuilderFiles.isEmpty()) {
				_buildType = BuildType.FULL;

				return;
			}

			List<File> modifiedPortalImplFiles =
				JenkinsResultsParserUtil.getIncludedFiles(
					null,
					getPathMatchers(
						"portal-impl/**",
						portalGitWorkingDirectory.getWorkingDirectory()),
					modifiedFiles);

			if (!modifiedPortalImplFiles.isEmpty()) {
				_buildType = BuildType.CORE;
			}
			else {
				List<File> modifiedPortalKernelFiles =
					JenkinsResultsParserUtil.getIncludedFiles(
						null,
						getPathMatchers(
							"portal-kernel/**",
							portalGitWorkingDirectory.getWorkingDirectory()),
						modifiedFiles);

				if (!modifiedPortalKernelFiles.isEmpty()) {
					_buildType = BuildType.CORE;
				}
			}

			moduleDirsList.addAll(
				portalGitWorkingDirectory.getModifiedModuleDirsList(
					excludesPathMatchers, includesPathMatchers));
		}
		else {
			_buildType = BuildType.FULL;

			return;
		}

		for (File moduleDir : moduleDirsList) {
			List<File> modulesProjectDirs = getModulesProjectDirs(moduleDir);

			if (!modulesProjectDirs.isEmpty()) {
				testClasses.add(
					ServiceBuilderBatchTestClass.getInstance(
						moduleDir, portalModulesBaseDir, modulesProjectDirs));
			}
		}
	}

	private BuildType _buildType;

}