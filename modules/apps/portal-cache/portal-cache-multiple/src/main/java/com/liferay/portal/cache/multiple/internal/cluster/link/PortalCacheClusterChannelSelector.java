/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.multiple.internal.cluster.link;

import com.liferay.portal.cache.multiple.internal.PortalCacheClusterEvent;

import java.util.List;

/**
 * @author Shuyang Zhou
 */
public interface PortalCacheClusterChannelSelector {

	public long getSelectedNumber();

	public PortalCacheClusterChannel select(
		List<PortalCacheClusterChannel> portalCacheClusterChannels,
		PortalCacheClusterEvent portalCacheClusterEvent);

}