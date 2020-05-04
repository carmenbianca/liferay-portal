/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.rule;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author Matthew Tambara
 */
public abstract class ClassTestRule<C> extends AbstractTestRule<C, Void> {

	@Override
	protected void afterMethod(Description description, Void v, Object target) {
	}

	@Override
	protected Void beforeMethod(Description description, Object target) {
		return null;
	}

	@Override
	protected Statement createMethodStatement(
		Statement statement, Description description) {

		return statement;
	}

}