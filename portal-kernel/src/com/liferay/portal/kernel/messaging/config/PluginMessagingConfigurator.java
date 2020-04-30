/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging.config;

import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.servlet.ServletContextClassLoaderPool;

/**
 * @author Michael C. Han
 */
public class PluginMessagingConfigurator extends BaseMessagingConfigurator {

	@Override
	public void afterPropertiesSet() {
		_servletContextName = PortletClassLoaderUtil.getServletContextName();

		super.afterPropertiesSet();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getOperatingClassLoader()}
	 */
	@Deprecated
	@Override
	protected ClassLoader getOperatingClassloader() {
		return getOperatingClassLoader();
	}

	@Override
	protected ClassLoader getOperatingClassLoader() {
		ClassLoader classLoader = ServletContextClassLoaderPool.getClassLoader(
			_servletContextName);

		if (classLoader == null) {
			throw new IllegalStateException(
				"Unable to find the class loader for servlet context " +
					_servletContextName);
		}

		return classLoader;
	}

	private String _servletContextName;

}