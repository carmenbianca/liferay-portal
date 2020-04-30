/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.operation;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Matija Petanjek
 */
public class LiferayUpdateOperationTest extends BaseLiferayOperationTestCase {

	@Test
	public void testUpdateOperation() throws Exception {
		String payload = getPayload("test-update-product-flow");

		Assert.assertTrue(
			payload.contains("\"en_US\" : \"Updated Test Product\""));
	}

	@Override
	protected String getConfigFile() {
		return "test-update-operation.xml";
	}

}