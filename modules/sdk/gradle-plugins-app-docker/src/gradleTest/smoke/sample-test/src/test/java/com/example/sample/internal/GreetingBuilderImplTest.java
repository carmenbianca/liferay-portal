/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.example.sample.internal;

import com.example.sample.GreetingBuilder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Andrea Di Giorgi
 */
public class GreetingBuilderImplTest {

	@Test
	public void testGetHello() {
		GreetingBuilder greetingBuilder = new GreetingBuilderImpl("World");

		Assert.assertEquals("Hello World", greetingBuilder.getHello());
	}

}