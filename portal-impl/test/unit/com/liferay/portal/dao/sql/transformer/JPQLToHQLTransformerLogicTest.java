/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.sql.transformer;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class JPQLToHQLTransformerLogicTest {

	@Test
	public void testReplaceCount() {
		Function<String, String> function =
			JPQLToHQLTransformerLogic.getCountFunction();

		Assert.assertEquals(
			"SELECT COUNT(*) FROM Foo foo",
			function.apply("SELECT COUNT(foo) FROM Foo foo"));
	}

	@Test
	public void testReplaceCountWithIncorrectAlias() {
		String sql = "SELECT COUNT(bar) FROM Foo foo";

		Function<String, String> function =
			JPQLToHQLTransformerLogic.getCountFunction();

		Assert.assertEquals(sql, function.apply(sql));
	}

	@Test
	public void testReplaceCountWithNoCount() {
		String sql = "SELECT * FROM Foo where foo != 1";

		Function<String, String> function =
			JPQLToHQLTransformerLogic.getCountFunction();

		Assert.assertEquals(sql, function.apply(sql));
	}

}