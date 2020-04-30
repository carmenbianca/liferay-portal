/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpHost;

import org.elasticsearch.client.Node;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author André de Oliveira
 */
public class RemoteElasticsearchConnectionTest {

	@Before
	public void setUp() {
		_remoteElasticsearchConnection = new RemoteElasticsearchConnection();
	}

	@Test
	public void testActivateNeverCloseNeverConnect() {
		Assert.assertNull(
			_remoteElasticsearchConnection.getRestHighLevelClient());

		HashMap<String, Object> properties = HashMapBuilder.<String, Object>put(
			"connectionId", "remote"
		).put(
			"networkHostAddresses", "http://localhost:9200"
		).build();

		_remoteElasticsearchConnection.activate(properties);

		Assert.assertNull(
			_remoteElasticsearchConnection.getRestHighLevelClient());

		_remoteElasticsearchConnection.connect();

		Assert.assertNotNull(
			_remoteElasticsearchConnection.getRestHighLevelClient());

		_remoteElasticsearchConnection.activate(properties);

		Assert.assertNotNull(
			_remoteElasticsearchConnection.getRestHighLevelClient());
	}

	@Test
	public void testGetConnectionId() {
		Assert.assertNull(_remoteElasticsearchConnection.getConnectionId());

		HashMap<String, Object> properties = HashMapBuilder.<String, Object>put(
			"connectionId", "remote"
		).put(
			"networkHostAddresses", "http://localhost:9200"
		).build();

		_remoteElasticsearchConnection.activate(properties);

		Assert.assertEquals(
			"remote", _remoteElasticsearchConnection.getConnectionId());
	}

	@Test
	public void testIsActive() {
		Assert.assertFalse(_remoteElasticsearchConnection.isActive());

		HashMap<String, Object> properties = HashMapBuilder.<String, Object>put(
			"active", "false"
		).put(
			"connectionId", "remote"
		).put(
			"networkHostAddresses", "http://localhost:9200"
		).build();

		_remoteElasticsearchConnection.activate(properties);

		Assert.assertFalse(_remoteElasticsearchConnection.isActive());

		properties.put("active", "true");

		_remoteElasticsearchConnection.activate(properties);

		Assert.assertTrue(_remoteElasticsearchConnection.isActive());
	}

	@Test
	public void testModifyConnected() {
		HashMap<String, Object> properties = HashMapBuilder.<String, Object>put(
			"connectionId", "remote"
		).put(
			"networkHostAddresses", "http://localhost:9200"
		).build();

		_remoteElasticsearchConnection.activate(properties);

		Assert.assertFalse(_remoteElasticsearchConnection.isConnected());

		_remoteElasticsearchConnection.connect();

		Assert.assertTrue(_remoteElasticsearchConnection.isConnected());

		assertNetworkHostAddress("localhost", 9200);

		properties.put("networkHostAddresses", "http://127.0.0.1:9999");

		_remoteElasticsearchConnection.activate(properties);

		_remoteElasticsearchConnection.connect();

		Assert.assertTrue(_remoteElasticsearchConnection.isConnected());

		assertNetworkHostAddress("127.0.0.1", 9999);
	}

	protected void assertNetworkHostAddress(String hostString, int port) {
		RestHighLevelClient restHighLevelClient =
			_remoteElasticsearchConnection.getRestHighLevelClient();

		RestClient restClient = restHighLevelClient.getLowLevelClient();

		List<Node> nodes = restClient.getNodes();

		Assert.assertEquals(nodes.toString(), 1, nodes.size());

		Node node = nodes.get(0);

		HttpHost httpHost = node.getHost();

		Assert.assertEquals(hostString, httpHost.getHostName());
		Assert.assertEquals(port, httpHost.getPort());
	}

	private RemoteElasticsearchConnection _remoteElasticsearchConnection;

}