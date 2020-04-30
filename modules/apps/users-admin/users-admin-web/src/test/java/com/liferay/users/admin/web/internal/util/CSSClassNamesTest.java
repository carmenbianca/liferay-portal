/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Drew Brokke
 */
public class CSSClassNamesTest {

	@Test
	public void testBasicOutput() {
		Assert.assertEquals(
			"hello",
			CSSClassNames.builder(
				"hello"
			).build());
		Assert.assertEquals(
			"hello world",
			CSSClassNames.builder(
				"hello", "world"
			).build());
	}

	@Test
	public void testConditionalOutput() {
		Assert.assertEquals(
			"hello world",
			CSSClassNames.builder(
				"hello"
			).add(
				"goodbye", false
			).add(
				"sad", false
			).add(
				"world", true
			).build());
		Assert.assertEquals(
			"foo hello world",
			CSSClassNames.builder(
				"hello", "world"
			).add(
				"cruel", false
			).add(
				"foo", true
			).build());
	}

	@Test
	public void testDistinctOutput() {
		Assert.assertEquals(
			"hello world",
			CSSClassNames.builder(
				"hello", "hello", "world", "world"
			).build());
		Assert.assertEquals(
			"hello world",
			CSSClassNames.builder(
				"hello"
			).add(
				"hello"
			).add(
				"world"
			).add(
				"world"
			).build());
	}

	@Test
	public void testSortedOutput() {
		Assert.assertEquals(
			"hello world",
			CSSClassNames.builder(
				"world", "hello"
			).build());
		Assert.assertEquals(
			"alpha beta gamma",
			CSSClassNames.builder(
				"beta"
			).add(
				"gamma"
			).add(
				"alpha"
			).build());
	}

}