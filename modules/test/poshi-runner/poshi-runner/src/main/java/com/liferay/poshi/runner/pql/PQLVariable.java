/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.pql;

import com.liferay.poshi.runner.PoshiRunnerContext;

import java.util.List;
import java.util.Properties;

/**
 * @author Michael Hashimoto
 */
public class PQLVariable extends PQLValue {

	public static boolean isVariable(String variable) {
		if (variable == null) {
			return false;
		}

		if (_availablePropertyNames.contains(variable)) {
			return true;
		}

		return false;
	}

	public PQLVariable(String variable) throws Exception {
		super(variable);

		_validateVariable(getPQL());
	}

	@Override
	public Object getPQLResult(Properties properties) throws Exception {
		String pql = getPQL();

		if (!properties.containsKey(pql)) {
			return null;
		}

		String value = properties.getProperty(pql);

		if (!(value.startsWith("'") && value.endsWith("'")) &&
			!(value.startsWith("\"") && value.endsWith("\"")) &&
			value.contains(" ")) {

			value = "'" + value + "'";
		}

		return getObjectValue(value);
	}

	private static void _validateVariable(String variable) throws Exception {
		if (variable == null) {
			throw new Exception("Invalid variable: " + variable);
		}

		variable.trim();

		if (!isVariable(variable)) {
			throw new Exception("Invalid testcase property: " + variable);
		}
	}

	private static final List<String> _availablePropertyNames =
		PoshiRunnerContext.getTestCaseAvailablePropertyNames();

}