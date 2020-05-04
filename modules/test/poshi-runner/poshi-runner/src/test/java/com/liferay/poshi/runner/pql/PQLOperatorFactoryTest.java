/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.pql;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author Michael Hashimoto
 */
public class PQLOperatorFactoryTest extends TestCase {

	@Test
	public void testNewPQLOperator() throws Exception {
		Set<String> availableOperators = PQLOperator.getAvailableOperators();

		for (String operator : availableOperators) {
			PQLOperatorFactory.newPQLOperator(operator);
		}
	}

	@Test
	public void testNewPQLOperatorError() throws Exception {
		Set<String> operators = new HashSet<>();

		operators.add(null);
		operators.add("bad");
		operators.add("bad value");
		operators.addAll(PQLModifier.getAvailableModifiers());

		for (String operator : operators) {
			_validateNewPQLOperatorError(
				operator, "Invalid operator: " + operator);
		}
	}

	private void _validateNewPQLOperatorError(
			String operator, String expectedError)
		throws Exception {

		String actualError = null;

		try {
			PQLOperatorFactory.newPQLOperator(operator);
		}
		catch (Exception exception) {
			actualError = exception.getMessage();

			if (!actualError.equals(expectedError)) {
				StringBuilder sb = new StringBuilder();

				sb.append("Mismatched error thrown for new PQL operators:");
				sb.append("\n* Actual:   ");
				sb.append(actualError);
				sb.append("\n* Expected: ");
				sb.append(expectedError);

				throw new Exception(sb.toString(), exception);
			}
		}
		finally {
			if (actualError == null) {
				throw new Exception(
					"No error thrown for the following operator: " + operator);
			}
		}
	}

}