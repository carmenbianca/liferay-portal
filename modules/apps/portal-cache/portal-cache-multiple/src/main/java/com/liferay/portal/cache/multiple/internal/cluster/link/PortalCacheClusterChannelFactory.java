/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.multiple.internal.cluster.link;

import com.liferay.portal.cache.multiple.internal.PortalCacheClusterException;
import com.liferay.portal.kernel.cluster.Priority;

/**
 * @author Shuyang Zhou
 */
public interface PortalCacheClusterChannelFactory {

	public PortalCacheClusterChannel createPortalCacheClusterChannel(
			Priority priority)
		throws PortalCacheClusterException;

}