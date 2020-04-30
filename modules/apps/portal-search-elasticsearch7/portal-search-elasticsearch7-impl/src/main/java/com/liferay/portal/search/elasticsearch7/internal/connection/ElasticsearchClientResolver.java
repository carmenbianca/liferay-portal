/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author André de Oliveira
 */
public interface ElasticsearchClientResolver {

	public RestHighLevelClient getRestHighLevelClient();

	public RestHighLevelClient getRestHighLevelClient(String connectionId);

	public RestHighLevelClient getRestHighLevelClient(
		String connectionId, boolean preferLocalCluster);

}