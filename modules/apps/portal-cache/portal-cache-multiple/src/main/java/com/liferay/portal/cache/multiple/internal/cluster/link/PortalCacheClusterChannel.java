/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.multiple.internal.cluster.link;

import com.liferay.portal.cache.multiple.internal.PortalCacheClusterEvent;

/**
 * @author Shuyang Zhou
 */
public interface PortalCacheClusterChannel {

	public void destroy();

	public long getCoalescedEventNumber();

	public int getPendingEventNumber();

	public long getSentEventNumber();

	public void sendEvent(PortalCacheClusterEvent portalCacheClusterEvent);

}