/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.jsonwebservice;

import com.liferay.portal.kernel.util.CamelCaseUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Igor Spasic
 */
public class CamelCaseUtilTest {

	@Test
	public void testFromCamelCase() {
		Assert.assertEquals(
			"camel-case", CamelCaseUtil.fromCamelCase("camelCase"));
		Assert.assertEquals(
			"camel-case-word", CamelCaseUtil.fromCamelCase("camelCASEWord"));
		Assert.assertEquals(
			"camel-case", CamelCaseUtil.fromCamelCase("camelCASE"));
	}

	@Test
	public void testNormalization() {
		Assert.assertEquals(
			"camelCase", CamelCaseUtil.normalizeCamelCase("camelCase", true));
		Assert.assertEquals(
			"camelCase", CamelCaseUtil.normalizeCamelCase("camelCase", false));
		Assert.assertEquals(
			"camelCaseWord",
			CamelCaseUtil.normalizeCamelCase("camelCASEWord", true));
		Assert.assertEquals(
			"camelCaseWord",
			CamelCaseUtil.normalizeCamelCase("camelCASEWord", false));
		Assert.assertEquals(
			"camelCase", CamelCaseUtil.normalizeCamelCase("camelCASE", true));
		Assert.assertEquals(
			"camelCase", CamelCaseUtil.normalizeCamelCase("camelCASE", false));
		Assert.assertEquals(
			"camelCase.fooUrl",
			CamelCaseUtil.normalizeCamelCase("camelCASE.fooURL", true));
		Assert.assertEquals(
			"camelCase.fooURL",
			CamelCaseUtil.normalizeCamelCase("camelCASE.fooURL", false));
	}

	@Test
	public void testToCamelCase() {
		Assert.assertEquals(
			"camelCase", CamelCaseUtil.toCamelCase("camel-case"));
		Assert.assertEquals(
			"camelCASEWord", CamelCaseUtil.toCamelCase("camel-CASE-word"));
		Assert.assertEquals(
			"camelCASE", CamelCaseUtil.toCamelCase("camel-CASE"));
	}

}