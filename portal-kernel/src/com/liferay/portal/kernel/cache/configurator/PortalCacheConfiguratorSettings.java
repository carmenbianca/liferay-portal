/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache.configurator;

/**
 * @author     Tina Tian
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class PortalCacheConfiguratorSettings {

	public PortalCacheConfiguratorSettings(
		ClassLoader classLoader, String portalCacheConfigrationLocation) {

		_classLoader = classLoader;
		_portalCacheConfigrationLocation = portalCacheConfigrationLocation;
	}

	public ClassLoader getClassLoader() {
		return _classLoader;
	}

	public String getPortalCacheConfigrationLocation() {
		return _portalCacheConfigrationLocation;
	}

	private final ClassLoader _classLoader;
	private final String _portalCacheConfigrationLocation;

}