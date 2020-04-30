/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class DummyFilterChain implements FilterChain {

	@Override
	public void doFilter(
		ServletRequest servletRequest, ServletResponse servletResponse) {
	}

}