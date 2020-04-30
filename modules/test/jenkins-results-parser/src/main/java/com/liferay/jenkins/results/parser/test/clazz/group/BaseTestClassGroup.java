/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter Yoo
 */
public abstract class BaseTestClassGroup implements TestClassGroup {

	@Override
	public List<TestClassGroup.TestClass> getTestClasses() {
		return testClasses;
	}

	@Override
	public List<TestClass.TestClassFile> getTestClassFiles() {
		List<TestClass.TestClassFile> testClassFiles = new ArrayList<>();

		for (TestClassGroup.TestClass testClass : testClasses) {
			testClassFiles.add(testClass.getTestClassFile());
		}

		return testClassFiles;
	}

	public abstract static class BaseTestClass
		implements TestClassGroup.TestClass {

		@Override
		public int compareTo(TestClassGroup.TestClass testClass) {
			if (testClass == null) {
				throw new NullPointerException("Test class is null");
			}

			return _testClassFile.compareTo(testClass.getTestClassFile());
		}

		@Override
		public TestClassFile getTestClassFile() {
			return _testClassFile;
		}

		@Override
		public List<TestClassGroup.TestClass.TestClassMethod>
			getTestClassMethods() {

			return _testClassMethods;
		}

		protected BaseTestClass(TestClassFile testClassFile) {
			_testClassFile = testClassFile;
		}

		protected void addTestClassMethod(
			boolean methodIgnored, String methodName) {

			addTestClassMethod(
				new TestClassMethod(methodIgnored, methodName, this));
		}

		protected void addTestClassMethod(String methodName) {
			addTestClassMethod(false, methodName);
		}

		protected void addTestClassMethod(
			TestClassGroup.TestClass.TestClassMethod testClassMethod) {

			_testClassMethods.add(testClassMethod);
		}

		private final TestClassFile _testClassFile;
		private final List<TestClassMethod> _testClassMethods =
			new ArrayList<>();

	}

	protected void addTestClass(TestClassGroup.TestClass testClass) {
		testClasses.add(testClass);
	}

	protected final List<TestClassGroup.TestClass> testClasses =
		new ArrayList<>();

}