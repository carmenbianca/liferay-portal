/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.connection;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.Client;

/**
 * @author Michael C. Han
 */
public interface ElasticsearchConnection {

	public void close();

	public void connect();

	public Client getClient();

	public ClusterHealthResponse getClusterHealthResponse(long timeout);

	public OperationMode getOperationMode();

}