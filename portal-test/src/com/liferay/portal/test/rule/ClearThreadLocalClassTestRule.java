/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.test.rule;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.portal.kernel.test.rule.ClassTestRule;

import org.junit.runner.Description;

/**
 * @author Shuyang Zhou
 */
public class ClearThreadLocalClassTestRule extends ClassTestRule<Void> {

	public static final ClearThreadLocalClassTestRule INSTANCE =
		new ClearThreadLocalClassTestRule();

	@Override
	protected void afterClass(Description description, Void v) {
		CentralizedThreadLocal.clearShortLivedThreadLocals();
	}

	@Override
	protected Void beforeClass(Description description) {
		return null;
	}

	private ClearThreadLocalClassTestRule() {
	}

}