/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.secure;

import javax.servlet.FilterConfig;

/**
 * @author Mariano Álvaro Sáiz
 * @author Arthur Chan
 */
public class SecureFilter extends BaseAuthFilter {

	@Override
	public void init(FilterConfig filterConfig) {
		super.init(filterConfig);

		setFilterEnabled(true);
	}

	@Override
	public boolean isFilterEnabled() {
		return true;
	}

}