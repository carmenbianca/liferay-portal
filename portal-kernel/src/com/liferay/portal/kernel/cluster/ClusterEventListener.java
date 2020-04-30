/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

/**
 * @author Tina Tian
 */
public interface ClusterEventListener {

	public void processClusterEvent(ClusterEvent clusterEvent);

}