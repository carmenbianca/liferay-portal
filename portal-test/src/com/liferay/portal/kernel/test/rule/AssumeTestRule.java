/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.rule;

import com.liferay.portal.kernel.test.ReflectionTestUtil;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author Shuyang Zhou
 */
public class AssumeTestRule implements TestRule {

	public AssumeTestRule(String assumeMethodName) {
		_assumeMethodName = assumeMethodName;
	}

	@Override
	public Statement apply(Statement statement, Description description) {
		ReflectionTestUtil.invoke(
			description.getTestClass(), _assumeMethodName, new Class<?>[0]);

		return statement;
	}

	private final String _assumeMethodName;

}