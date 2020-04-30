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
public class SetDataTypeFunctionTest {

	@Test
	public void testGetPropertyName() {
		SetDataTypeFunction setDataTypeFunction = new SetDataTypeFunction();

		Assert.assertEquals("dataType", setDataTypeFunction.getPropertyName());
	}

}