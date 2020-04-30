/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache;

import java.io.Serializable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @author Michael Young
 */
@ProviderType
public interface MultiVMPool {

	public void clear();

	public PortalCache<? extends Serializable, ? extends Serializable>
		getPortalCache(String portalCacheName);

	public PortalCache<? extends Serializable, ? extends Serializable>
		getPortalCache(String portalCacheName, boolean blocking);

	public PortalCache<? extends Serializable, ? extends Serializable>
		getPortalCache(String portalCacheName, boolean blocking, boolean mvcc);

	public PortalCacheManager<? extends Serializable, ? extends Serializable>
		getPortalCacheManager();

	public void removePortalCache(String portalCacheName);

}