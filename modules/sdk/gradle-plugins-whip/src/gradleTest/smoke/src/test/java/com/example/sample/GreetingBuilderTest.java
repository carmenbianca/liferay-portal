/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.example.sample;

import com.liferay.portal.kernel.test.rule.CodeCoverageAssertor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author Andrea Di Giorgi
 */
public class GreetingBuilderTest {

	@ClassRule
	public static final CodeCoverageAssertor codeCoverageAssertor =
		CodeCoverageAssertor.INSTANCE;

	@Before
	public void setUp() {
		_greetingBuilder = new GreetingBuilder("World");
	}

	@Test
	public void testGetGoodbye() {
		Assert.assertEquals("Goodbye World", _greetingBuilder.getGoodbye());
	}

	@Test
	public void testGetHello() {
		Assert.assertEquals("Hello World", _greetingBuilder.getHello());
	}

	private GreetingBuilder _greetingBuilder;

}