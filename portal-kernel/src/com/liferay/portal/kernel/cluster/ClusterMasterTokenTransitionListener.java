/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

/**
 * @author Michael C. Han
 */
public interface ClusterMasterTokenTransitionListener {

	public void masterTokenAcquired();

	public void masterTokenReleased();

}