/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.cluster;

import com.liferay.portal.search.engine.adapter.cluster.ClusterHealthStatus;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = ClusterHealthStatusTranslator.class)
public class ClusterHealthStatusTranslatorImpl
	implements ClusterHealthStatusTranslator {

	@Override
	public org.elasticsearch.cluster.health.ClusterHealthStatus translate(
		ClusterHealthStatus clusterHealthStatus) {

		if (clusterHealthStatus == ClusterHealthStatus.GREEN) {
			return org.elasticsearch.cluster.health.ClusterHealthStatus.GREEN;
		}

		if (clusterHealthStatus == ClusterHealthStatus.RED) {
			return org.elasticsearch.cluster.health.ClusterHealthStatus.RED;
		}

		if (clusterHealthStatus == ClusterHealthStatus.YELLOW) {
			return org.elasticsearch.cluster.health.ClusterHealthStatus.YELLOW;
		}

		throw new IllegalArgumentException(
			"Unknown status: " + clusterHealthStatus);
	}

	@Override
	public ClusterHealthStatus translate(
		org.elasticsearch.cluster.health.ClusterHealthStatus
			clusterHealthStatus) {

		if (clusterHealthStatus ==
				org.elasticsearch.cluster.health.ClusterHealthStatus.GREEN) {

			return ClusterHealthStatus.GREEN;
		}

		if (clusterHealthStatus ==
				org.elasticsearch.cluster.health.ClusterHealthStatus.RED) {

			return ClusterHealthStatus.RED;
		}

		if (clusterHealthStatus ==
				org.elasticsearch.cluster.health.ClusterHealthStatus.YELLOW) {

			return ClusterHealthStatus.YELLOW;
		}

		throw new IllegalArgumentException(
			"Unknown status: " + clusterHealthStatus);
	}

}