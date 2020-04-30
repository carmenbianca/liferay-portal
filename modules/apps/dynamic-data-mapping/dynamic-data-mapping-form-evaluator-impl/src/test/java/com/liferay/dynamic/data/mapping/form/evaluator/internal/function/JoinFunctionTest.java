/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.json.JSONArrayImpl;
import com.liferay.portal.kernel.json.JSONArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Leonardo Barros
 */
public class JoinFunctionTest {

	@Test
	public void testArray() {
		JSONArray jsonArray = new JSONArrayImpl();

		jsonArray.put(
			"value1"
		).put(
			"value2"
		);

		JoinFunction joinFunction = new JoinFunction();

		String actual = joinFunction.apply(jsonArray);

		Assert.assertEquals("value1,value2", actual);
	}

	@Test
	public void testEmptyArray() {
		JSONArray jsonArray = new JSONArrayImpl();

		JoinFunction joinFunction = new JoinFunction();

		String actual = joinFunction.apply(jsonArray);

		Assert.assertEquals(StringPool.BLANK, actual);
	}

	@Test
	public void testSingleValue() {
		JSONArray jsonArray = new JSONArrayImpl();

		jsonArray.put("value1");

		JoinFunction joinFunction = new JoinFunction();

		String actual = joinFunction.apply(jsonArray);

		Assert.assertEquals("value1", actual);
	}

}