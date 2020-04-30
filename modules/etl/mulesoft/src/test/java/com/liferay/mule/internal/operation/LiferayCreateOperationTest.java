/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.operation;

import java.util.regex.Matcher;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Matija Petanjek
 */
public class LiferayCreateOperationTest extends BaseLiferayOperationTestCase {

	@Test
	public void testCreateOperation() throws Exception {
		String payload = getPayload("test-create-product-flow");

		Matcher matcher = productPattern.matcher(payload);

		Assert.assertTrue(matcher.matches());
	}

	@Override
	protected String getConfigFile() {
		return "test-create-operation.xml";
	}

}