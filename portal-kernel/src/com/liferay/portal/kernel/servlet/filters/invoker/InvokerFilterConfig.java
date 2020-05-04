/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.filters.invoker;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

/**
 * @author Mika Koivisto
 * @author Brian Wing Shun Chan
 */
public class InvokerFilterConfig implements FilterConfig {

	public InvokerFilterConfig(
		ServletContext servletContext, String filterName,
		Map<String, String> initParameterMap) {

		_servletContext = servletContext;
		_filterName = filterName;
		_initParameterMap = initParameterMap;
	}

	@Override
	public String getFilterName() {
		return _filterName;
	}

	@Override
	public String getInitParameter(String key) {
		return _initParameterMap.get(key);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return new Enumeration<String>() {

			@Override
			public boolean hasMoreElements() {
				return _keys.hasNext();
			}

			@Override
			public String nextElement() {
				return _keys.next();
			}

			private final Iterator<String> _keys = _initParameterMap.keySet(
			).iterator();

		};
	}

	@Override
	public ServletContext getServletContext() {
		return _servletContext;
	}

	private final String _filterName;
	private final Map<String, String> _initParameterMap;
	private final ServletContext _servletContext;

}