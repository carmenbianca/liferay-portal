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
public class ConcatFunctionTest {

	@Test
	public void testApply1() {
		ConcatFunction concatFunction = new ConcatFunction();

		String actualString = concatFunction.apply(
			new String[] {"liferay", "forms"});

		Assert.assertEquals("liferayforms", actualString);
	}

	@Test
	public void testApply2() {
		ConcatFunction concatFunction = new ConcatFunction();

		String actualString = concatFunction.apply(
			new String[] {"liferay", null, "forms"});

		Assert.assertEquals("liferayforms", actualString);
	}

	@Test
	public void testApply3() {
		ConcatFunction concatFunction = new ConcatFunction();

		String actualString = concatFunction.apply(
			new String[] {"liferay", null});

		Assert.assertEquals("liferay", actualString);
	}

	@Test
	public void testApply4() {
		ConcatFunction concatFunction = new ConcatFunction();

		String actualString = concatFunction.apply(new String[] {null, null});

		Assert.assertEquals("", actualString);
	}

}