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
public class PQLModifierFactoryTest extends TestCase {

	@Test
	public void testNewPQLModifier() throws Exception {
		Set<String> availableModifiers = PQLModifier.getAvailableModifiers();

		for (String modifier : availableModifiers) {
			PQLModifierFactory.newPQLModifier(modifier);
		}
	}

	@Test
	public void testNewPQLModifierError() throws Exception {
		Set<String> modifiers = new HashSet<>();

		modifiers.add(null);
		modifiers.add("bad");
		modifiers.add("bad value");
		modifiers.addAll(PQLOperator.getAvailableOperators());

		for (String modifier : modifiers) {
			_validateNewPQLModifierError(
				modifier, "Invalid modifier: " + modifier);
		}
	}

	private void _validateNewPQLModifierError(
			String modifier, String expectedError)
		throws Exception {

		String actualError = null;

		try {
			PQLModifierFactory.newPQLModifier(modifier);
		}
		catch (Exception exception) {
			actualError = exception.getMessage();

			if (!actualError.equals(expectedError)) {
				StringBuilder sb = new StringBuilder();

				sb.append("Mismatched error thrown for new PQL modifiers:");
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
					"No error thrown for the following modifier: " + modifier);
			}
		}
	}

}