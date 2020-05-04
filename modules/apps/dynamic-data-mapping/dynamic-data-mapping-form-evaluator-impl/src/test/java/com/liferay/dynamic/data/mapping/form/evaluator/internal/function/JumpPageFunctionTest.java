/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import com.liferay.dynamic.data.mapping.expression.ExecuteActionRequest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import org.powermock.api.mockito.PowerMockito;

/**
 * @author Inácio Nery
 * @author Leonardo Barros
 */
@RunWith(MockitoJUnitRunner.class)
public class JumpPageFunctionTest extends PowerMockito {

	@Test
	public void testExecuteAction() {
		DefaultDDMExpressionActionHandler defaultDDMExpressionActionHandler =
			new DefaultDDMExpressionActionHandler();

		DefaultDDMExpressionActionHandler spy = spy(
			defaultDDMExpressionActionHandler);

		JumpPageFunction jumpPageFunction = new JumpPageFunction();

		jumpPageFunction.setDDMExpressionActionHandler(spy);

		Boolean result = jumpPageFunction.apply(1, 3);

		ArgumentCaptor<ExecuteActionRequest> argumentCaptor =
			ArgumentCaptor.forClass(ExecuteActionRequest.class);

		Mockito.verify(
			spy, Mockito.times(1)
		).executeAction(
			argumentCaptor.capture()
		);

		ExecuteActionRequest executeActionRequest = argumentCaptor.getValue();

		Assert.assertEquals("jumpPage", executeActionRequest.getAction());
		Assert.assertEquals(
			1,
			executeActionRequest.getParameterOptional(
				"from"
			).get());
		Assert.assertEquals(
			3,
			executeActionRequest.getParameterOptional(
				"to"
			).get());

		Assert.assertTrue(result);
	}

	@Test
	public void testNullActionHandler() {
		JumpPageFunction jumpPageFunction = new JumpPageFunction();

		Boolean result = jumpPageFunction.apply(1, 3);

		Assert.assertFalse(result);
	}

}