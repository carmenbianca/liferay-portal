/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Michael C. Han
 */
public interface ElasticsearchConnection {

	public void close();

	public void connect();

	public String getConnectionId();

	public OperationMode getOperationMode();

	public RestHighLevelClient getRestHighLevelClient();

	public boolean isActive();

}