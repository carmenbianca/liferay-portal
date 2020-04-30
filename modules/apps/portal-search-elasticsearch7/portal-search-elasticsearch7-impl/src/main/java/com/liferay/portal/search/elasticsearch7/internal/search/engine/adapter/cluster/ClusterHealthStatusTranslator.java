/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.cluster;

import com.liferay.portal.search.engine.adapter.cluster.ClusterHealthStatus;

/**
 * @author Michael C. Han
 */
public interface ClusterHealthStatusTranslator {

	public org.elasticsearch.cluster.health.ClusterHealthStatus translate(
		ClusterHealthStatus clusterHealthStatus);

	public ClusterHealthStatus translate(
		org.elasticsearch.cluster.health.ClusterHealthStatus
			clusterHealthStatus);

	public ClusterHealthStatus translate(String status);

}