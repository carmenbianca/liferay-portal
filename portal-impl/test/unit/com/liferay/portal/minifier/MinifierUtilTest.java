/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.minifier;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.ProxyFactory;
import com.liferay.registry.BasicRegistryImpl;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Iván Zaera Avellón
 */
public class MinifierUtilTest {

	@Before
	public void setUp() {
		Registry registry = new BasicRegistryImpl();

		RegistryUtil.setRegistry(registry);

		registry.registerService(
			JavaScriptMinifier.class,
			ProxyFactory.newDummyInstance(JavaScriptMinifier.class));
	}

	@Test
	public void testProcessMinifiedCssWithDataImageUrl() {
		String minifiedCss = MinifierUtil.minifyCss(
			StringBundler.concat(
				"background-image: url(\"data:image/svg+xml;charset=utf8,%3C",
				"svg xmlns='http://www.w3.org/2000/svg' viewBox='-4 -4 8 ",
				"8'%3E%3Ccircle r='3' fill='%23FFF'/%3E%3C/svg%3E\");"));

		Assert.assertEquals(
			StringBundler.concat(
				"background-image:url(\"data:image/svg+xml;charset=utf8,%3C",
				"svg xmlns='http://www.w3.org/2000/svg' viewBox='-4 -4 8 ",
				"8'%3E%3Ccircle r='3' fill='%23FFF'/%3E%3C/svg%3E\");"),
			minifiedCss);
	}

	@Test
	public void testProcessMinifiedCssWithMultipleOps() {
		String minifiedCss = MinifierUtil.minifyCss(
			"margin: calc(10px + 50% * 2 / 3);");

		Assert.assertEquals("margin:calc(10px + 50% * 2 / 3);", minifiedCss);
	}

	@Test
	public void testProcessMinifiedCssWithNegativeNumbers() {
		String minifiedCss = MinifierUtil.minifyCss(
			"left: calc(-1px + -1px - -1px * -1px / -1px - 1px);");

		Assert.assertEquals(
			"left:calc(-1px + -1px - -1px * -1px / -1px - 1px);", minifiedCss);
	}

	@Test
	public void testProcessMinifiedCssWithParentheses() {
		String minifiedCss = MinifierUtil.minifyCss(
			"left: calc((10px + 50%) * 2 + 20px);");

		Assert.assertEquals("left:calc((10px + 50%) * 2 + 20px);", minifiedCss);
	}

	@Test
	public void testProcessMinifiedCssWithSimpleOps() {
		String minifiedCss = MinifierUtil.minifyCss(
			"margin: calc(50% - 10px) calc(50% - 10px) calc(1 * 50%) " +
				"calc(10px / 2);");

		Assert.assertEquals(
			"margin:calc(50% - 10px) calc(50% - 10px) calc(1 * 50%) " +
				"calc(10px / 2);",
			minifiedCss);
	}

}