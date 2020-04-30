/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.secure;

import com.liferay.portal.kernel.util.ProxyFactory;
import com.liferay.portal.util.PropsUtil;

import javax.servlet.FilterConfig;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Mariano Álvaro Sáiz
 */
public class SecureFilterTest {

	@Test
	public void testSecureFilterIsEnabledIfDisabled() {
		PropsUtil.set(SecureFilter.class.getName(), "false");

		SecureFilter secureFilter = new SecureFilter();

		secureFilter.init(_filterConfig);

		Assert.assertTrue(secureFilter.isFilterEnabled());
	}

	@Test
	public void testSecureFilterIsEnabledIfEnabled() {
		PropsUtil.set(SecureFilter.class.getName(), "true");

		SecureFilter secureFilter = new SecureFilter();

		secureFilter.init(_filterConfig);

		Assert.assertTrue(secureFilter.isFilterEnabled());
	}

	private final FilterConfig _filterConfig = ProxyFactory.newDummyInstance(
		FilterConfig.class);

}