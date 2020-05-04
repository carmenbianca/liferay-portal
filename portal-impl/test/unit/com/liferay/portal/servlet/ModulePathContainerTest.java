/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.tools.ToolDependencies;
import com.liferay.portal.util.HttpImpl;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Carlos Sierra Andrés
 * @author Raymond Augé
 */
public class ModulePathContainerTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		ToolDependencies.wireCaches();

		_http = HttpUtil.getHttp();

		_httpUtil.setHttp(new HttpImpl());
	}

	@AfterClass
	public static void tearDownClass() {
		_httpUtil.setHttp(_http);
	}

	@Test
	public void testModulePathWithNoContextPath() {
		String modulePath = "/js/javascript.js";

		Assert.assertEquals(
			PortletKeys.PORTAL, ComboServlet.getModulePortletId(modulePath));
		Assert.assertEquals(
			"/js/javascript.js", ComboServlet.getResourcePath(modulePath));
	}

	@Test
	public void testModulePathWithPortletId() {
		String modulePath = PortletKeys.PORTAL + ":/js/javascript.js";

		Assert.assertEquals(
			PortletKeys.PORTAL, ComboServlet.getModulePortletId(modulePath));
		Assert.assertEquals(
			"/js/javascript.js", ComboServlet.getResourcePath(modulePath));
	}

	@Test
	public void testModulePathWithPortletIdAndNoResourcePath() {
		String modulePath = PortletKeys.PORTAL + ":";

		Assert.assertEquals(
			PortletKeys.PORTAL, ComboServlet.getModulePortletId(modulePath));
		Assert.assertEquals(
			StringPool.BLANK, ComboServlet.getResourcePath(modulePath));
	}

	private static Http _http;
	private static final HttpUtil _httpUtil = new HttpUtil();

}