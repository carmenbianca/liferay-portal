/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import java.io.IOException;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Michael C. Han
 */
public abstract class BaseElasticsearchConnection
	implements ElasticsearchConnection {

	@Override
	public void close() {
		if (_restHighLevelClient == null) {
			return;
		}

		try {
			_restHighLevelClient.close();
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}

		_restHighLevelClient = null;
	}

	@Override
	public void connect() {
		_restHighLevelClient = createRestHighLevelClient();
	}

	@Override
	public RestHighLevelClient getRestHighLevelClient() {
		return _restHighLevelClient;
	}

	public boolean isConnected() {
		if (_restHighLevelClient != null) {
			return true;
		}

		return false;
	}

	protected abstract RestHighLevelClient createRestHighLevelClient();

	private RestHighLevelClient _restHighLevelClient;

}