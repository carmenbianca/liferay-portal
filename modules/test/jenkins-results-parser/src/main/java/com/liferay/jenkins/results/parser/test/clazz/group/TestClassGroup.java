/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.io.File;

import java.util.List;

/**
 * @author Peter Yoo
 */
public interface TestClassGroup {

	public List<TestClass> getTestClasses();

	public List<TestClass.TestClassFile> getTestClassFiles();

	public interface TestClass extends Comparable<TestClass> {

		public TestClassFile getTestClassFile();

		public List<TestClassMethod> getTestClassMethods();

		public static class TestClassFile extends File {

			public TestClassFile(File parent, String child) {
				super(parent, child);
			}

			public TestClassFile(String pathname) {
				super(pathname);
			}

			public String getRelativePath(File workingDirectory) {
				String canonicalPath =
					JenkinsResultsParserUtil.getCanonicalPath(this);
				String workingDirectoryCanonicalPath =
					JenkinsResultsParserUtil.getCanonicalPath(workingDirectory);

				if (!canonicalPath.startsWith(workingDirectoryCanonicalPath)) {
					throw new IllegalArgumentException(
						"Working directory does not contain this file");
				}

				return canonicalPath.replaceAll(
					workingDirectoryCanonicalPath, "");
			}

		}

		public static class TestClassMethod {

			public String getName() {
				return _name;
			}

			public TestClassGroup.TestClass getTestClass() {
				return _testClass;
			}

			public boolean isIgnored() {
				return _ignored;
			}

			protected TestClassMethod(
				boolean ignored, String name,
				BaseTestClassGroup.BaseTestClass testClass) {

				_ignored = ignored;
				_name = name;
				_testClass = testClass;
			}

			private final boolean _ignored;
			private final String _name;
			private final TestClassGroup.TestClass _testClass;

		}

	}

}