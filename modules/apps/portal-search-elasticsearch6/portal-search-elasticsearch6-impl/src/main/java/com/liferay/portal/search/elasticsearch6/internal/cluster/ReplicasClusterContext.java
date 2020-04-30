/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.cluster;

/**
 * @author André de Oliveira
 */
public interface ReplicasClusterContext {

	public int getClusterSize();

	public ReplicasManager getReplicasManager();

	public String[] getTargetIndexNames();

	public boolean isEmbeddedOperationMode();

	public boolean isMaster();

}