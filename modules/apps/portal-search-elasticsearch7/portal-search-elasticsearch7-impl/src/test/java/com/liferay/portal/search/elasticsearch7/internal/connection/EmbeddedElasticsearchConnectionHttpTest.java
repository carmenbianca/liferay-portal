/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.InputStream;

import java.net.URL;

import java.util.Map;
import java.util.Set;

import org.apache.http.util.EntityUtils;

import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import org.hamcrest.CoreMatchers;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.MockitoAnnotations;

/**
 * @author André de Oliveira
 */
public class EmbeddedElasticsearchConnectionHttpTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		setUpJSONFactoryUtil();

		_clusterName = RandomTestUtil.randomString();

		Map<String, Object> properties = HashMapBuilder.<String, Object>put(
			"clusterName", _clusterName
		).put(
			"networkHost", "_site_"
		).build();

		_elasticsearchFixture = new ElasticsearchFixture(
			EmbeddedElasticsearchConnectionHttpTest.class.getSimpleName(),
			properties);

		_elasticsearchFixture.setUp();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		_elasticsearchFixture.tearDown();
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testHttpLocallyAvailableRegardlessOfNetworkHost()
		throws Exception {

		String status = toString(new URL("http://localhost:" + getHttpPort()));

		Assert.assertThat(
			status,
			CoreMatchers.containsString(
				"\"cluster_name\" : \"" + _clusterName));
	}

	protected static void setUpJSONFactoryUtil() {
		JSONFactoryUtil jsonFactoryUtil = new JSONFactoryUtil();

		jsonFactoryUtil.setJSONFactory(_jsonFactory);
	}

	protected int getHttpPort() throws Exception {
		RestHighLevelClient restHighLevelClient =
			_elasticsearchFixture.getRestHighLevelClient();

		RestClient restClient = restHighLevelClient.getLowLevelClient();

		String endpoint = "/_nodes";

		Request request = new Request("GET", endpoint);

		Response response = restClient.performRequest(request);

		String responseBody = EntityUtils.toString(response.getEntity());

		JSONObject responseJSONObject = JSONFactoryUtil.createJSONObject(
			responseBody);

		JSONObject nodesJSONObject = responseJSONObject.getJSONObject("nodes");

		Set<String> nodes = nodesJSONObject.keySet();

		for (String node : nodes) {
			JSONObject nodeJSONObject = nodesJSONObject.getJSONObject(node);

			JSONObject settingsJSONObject = nodeJSONObject.getJSONObject(
				"settings");

			JSONObject httpJSONObject = settingsJSONObject.getJSONObject(
				"http");

			return httpJSONObject.getInt("port");
		}

		return 0;
	}

	protected String toString(URL url) throws Exception {
		try (InputStream inputStream = url.openStream()) {
			return StringUtil.read(inputStream);
		}
	}

	private static String _clusterName;
	private static ElasticsearchFixture _elasticsearchFixture;
	private static final JSONFactory _jsonFactory = new JSONFactoryImpl();

}