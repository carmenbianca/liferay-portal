/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet;

import com.liferay.portal.kernel.portlet.Route;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.util.HttpImpl;
import com.liferay.portlet.internal.RouteImpl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Connor McKay
 */
public class RouteImplTest {

	@Test
	public void testNonmatchingRoute() {
		HttpUtil httpUtil = new HttpUtil();

		httpUtil.setHttp(new HttpImpl());

		Map<String, String> parameters = HashMapBuilder.put(
			"action", "view"
		).put(
			"id", "bob"
		).build();

		Map<String, String> originalParameters = new HashMap<>(parameters);

		Route route = new RouteImpl("{action}/{id:\\d+}");

		String url = route.parametersToUrl(parameters);

		Assert.assertNull(url);

		Assert.assertEquals(originalParameters, parameters);
	}

}