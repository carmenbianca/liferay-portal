/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache;

/**
 * @author Shuyang Zhou
 */
public interface PortalCacheManagerListener {

	public void dispose() throws PortalCacheException;

	public void init() throws PortalCacheException;

	public void notifyPortalCacheAdded(String portalCacheName);

	public void notifyPortalCacheRemoved(String portalCacheName);

}