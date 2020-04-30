/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jeyvison Nascimento
 */
public class SetValidationFieldNameFunctionTest {

	@Test
	public void testName() {
		SetValidationFieldNameFunction setValidationFieldNameFunction =
			new SetValidationFieldNameFunction();

		Assert.assertEquals(
			"setValidationFieldName", setValidationFieldNameFunction.getName());
	}

	@Test
	public void testPropertyName() {
		SetValidationFieldNameFunction setValidationFieldNameFunction =
			new SetValidationFieldNameFunction();

		Assert.assertEquals(
			"validationFieldName",
			setValidationFieldNameFunction.getPropertyName());
	}

}