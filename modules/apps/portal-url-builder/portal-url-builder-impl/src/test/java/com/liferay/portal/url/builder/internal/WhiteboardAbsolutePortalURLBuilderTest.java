/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.url.builder.internal;

import com.liferay.portal.url.builder.AbsolutePortalURLBuilder;
import com.liferay.portal.url.builder.WhiteboardAbsolutePortalURLBuilder;

import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.mockito.Mockito;

/**
 * @author Iván Zaera Avellón
 */
@RunWith(Parameterized.class)
public class WhiteboardAbsolutePortalURLBuilderTest
	extends BaseAbsolutePortalURLBuilderTestCase {

	@Parameterized.Parameters(name = "{0}: context={1}, proxy={2}, cdnHost={3}")
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{0, false, false, false}, {1, false, false, true},
				{2, true, false, false}, {3, true, true, false},
				{4, false, true, false}
			});
	}

	@Before
	public void setUp() throws Exception {
		_absolutePortalURLBuilder = new AbsolutePortalURLBuilderImpl(
			mockPortal(context, proxy, cdnHost),
			Mockito.mock(HttpServletRequest.class));

		_whiteboardAbsolutePortalURLBuilder =
			_absolutePortalURLBuilder.forWhiteboard("path/to/resource");
	}

	@Test
	public void test() {
		String url = _whiteboardAbsolutePortalURLBuilder.build();

		Assert.assertEquals(_RESULTS[index], url);
	}

	@Test
	public void testIgnoreProxy() {
		_absolutePortalURLBuilder.ignorePathProxy();

		String url = _whiteboardAbsolutePortalURLBuilder.build();

		Assert.assertEquals(_RESULTS_IGNORE_PROXY[index], url);
	}

	@Parameterized.Parameter(3)
	public boolean cdnHost;

	@Parameterized.Parameter(1)
	public boolean context;

	@Parameterized.Parameter
	public int index;

	@Parameterized.Parameter(2)
	public boolean proxy;

	private static final String[] _RESULTS = {
		"/o/path/to/resource", "/o/path/to/resource",
		"/context/o/path/to/resource", "/proxy/context/o/path/to/resource",
		"/proxy/o/path/to/resource"
	};

	private static final String[] _RESULTS_IGNORE_PROXY = {
		"/o/path/to/resource", "/o/path/to/resource",
		"/context/o/path/to/resource", "/context/o/path/to/resource",
		"/o/path/to/resource"
	};

	private AbsolutePortalURLBuilder _absolutePortalURLBuilder;
	private WhiteboardAbsolutePortalURLBuilder
		_whiteboardAbsolutePortalURLBuilder;

}