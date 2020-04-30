/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.json.JSONObject;

/**
 * @author Kenji Heigel
 */
public class TestResultFactory {

	public static TestResult newTestResult(
		Build build, JSONObject caseJSONObject) {

		String className = caseJSONObject.getString("className");

		if (className.contains("com.liferay.poshi.runner.PoshiRunner")) {
			return new PoshiTestResult(build, caseJSONObject);
		}

		return new BaseTestResult(build, caseJSONObject);
	}

}