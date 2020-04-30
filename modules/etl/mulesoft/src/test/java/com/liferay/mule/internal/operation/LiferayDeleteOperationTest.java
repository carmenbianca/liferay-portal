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
public class LiferayDeleteOperationTest extends BaseLiferayOperationTestCase {

	@Test
	public void testDeleteOperation() throws Exception {
		String payload = getPayload("test-delete-product-flow");

		Assert.assertTrue(payload.isEmpty());
	}

	@Override
	protected String getConfigFile() {
		return "test-delete-operation.xml";
	}

}