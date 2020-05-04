/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.rule;

import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

/**
 * @author     Shuyang Zhou
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class ArquillianUtil {

	public static boolean isArquillianTest(Description description) {
		RunWith runWith = description.getAnnotation(RunWith.class);

		if (runWith == null) {
			return false;
		}

		Class<? extends Runner> runnerClass = runWith.value();

		String runnerClassName = runnerClass.getName();

		if (runnerClassName.equals(
				"com.liferay.arquillian.extension.junit.bridge.junit." +
					"Arquillian")) {

			return true;
		}

		return false;
	}

}