/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Matija Petanjek
 */
public class LiferayGetOperationTest extends BaseLiferayOperationTestCase {

	@Test
	public void testGetOperation() throws Exception {
		String payload = getPayload("test-get-products-flow");

		Matcher matcher = productPagePattern.matcher(payload);

		Assert.assertTrue(matcher.matches());
	}

	@Override
	protected String getConfigFile() {
		return "test-get-operation.xml";
	}

	private static final Pattern productPagePattern = Pattern.compile(
		"[\\s\\S]+\"items\"[\\s\\S]+\"active\"[\\s\\S]+\"catalogId\"[\\s\\S]+" +
			"\"name\"[\\s\\S]+\"productType\"[\\s\\S]+\"lastPage\"[\\s\\S]+" +
				"\"page\"[\\s\\S]+\"pageSize\"[\\s\\S]+\"totalCount\"" +
					"[\\s\\S]+");

}