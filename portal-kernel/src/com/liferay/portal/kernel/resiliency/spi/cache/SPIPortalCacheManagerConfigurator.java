/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resiliency.spi.cache;

import com.liferay.portal.kernel.cache.PortalCacheManager;

import java.io.Serializable;

/**
 * @author Tina Tian
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public interface SPIPortalCacheManagerConfigurator {

	public PortalCacheManager<? extends Serializable, ? extends Serializable>
			createSPIPortalCacheManager(
				PortalCacheManager
					<? extends Serializable, ? extends Serializable>
						portalCacheManager)
		throws Exception;

}