/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import com.liferay.portal.search.elasticsearch7.internal.sidecar.Sidecar;
import com.liferay.portal.search.elasticsearch7.internal.util.ClassLoaderUtil;

import org.apache.http.HttpHost;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Tina Tian
 */
public class SidecarElasticsearchConnection
	extends BaseElasticsearchConnection {

	public SidecarElasticsearchConnection(Sidecar sidecar) {
		_sidecar = sidecar;
	}

	@Override
	public void close() {
		super.close();

		_sidecar.stop();
	}

	@Override
	public void connect() {
		_sidecar.start();

		super.connect();
	}

	@Override
	public String getConnectionId() {
		return String.valueOf(OperationMode.EMBEDDED);
	}

	@Override
	public OperationMode getOperationMode() {
		return OperationMode.EMBEDDED;
	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	protected RestHighLevelClient createRestHighLevelClient() {
		return ClassLoaderUtil.getWithContextClassLoader(
			() -> new RestHighLevelClient(
				RestClient.builder(
					HttpHost.create(_sidecar.getNetworkHostAddress()))),
			getClass());
	}

	private final Sidecar _sidecar;

}