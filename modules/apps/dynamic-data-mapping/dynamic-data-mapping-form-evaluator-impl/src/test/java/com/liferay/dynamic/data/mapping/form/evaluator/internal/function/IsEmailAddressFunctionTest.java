/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Leonardo Barros
 */
public class IsEmailAddressFunctionTest {

	@Test
	public void testEmailList() {
		IsEmailAddressFunction isEmailAddressFunction =
			new IsEmailAddressFunction();

		Boolean result = isEmailAddressFunction.apply(
			"test1@liferay.com, test2@liferay.com");

		Assert.assertTrue(result);
	}

	@Test
	public void testInvalidEmail() {
		IsEmailAddressFunction isEmailAddressFunction =
			new IsEmailAddressFunction();

		Boolean result = isEmailAddressFunction.apply(
			"test1@liferay.com, invalid email");

		Assert.assertFalse(result);
	}

	@Test
	public void testSingleEmail() {
		IsEmailAddressFunction isEmailAddressFunction =
			new IsEmailAddressFunction();

		Boolean result = isEmailAddressFunction.apply("test@liferay.com");

		Assert.assertTrue(result);
	}

}