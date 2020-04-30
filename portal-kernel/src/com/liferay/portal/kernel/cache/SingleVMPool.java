/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @author Michael Young
 */
public interface SingleVMPool {

	public void clear();

	public PortalCache<? extends Serializable, ?> getPortalCache(
		String portalCacheName);

	public PortalCache<? extends Serializable, ?> getPortalCache(
		String portalCacheName, boolean blocking);

	public PortalCacheManager<? extends Serializable, ?>
		getPortalCacheManager();

	public void removePortalCache(String portalCacheName);

}