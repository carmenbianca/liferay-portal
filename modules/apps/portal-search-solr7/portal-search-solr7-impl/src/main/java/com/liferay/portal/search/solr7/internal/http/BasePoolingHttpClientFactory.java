/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.http;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;

/**
 * @author László Csontos
 * @author Bruno Farache
 * @author André de Oliveira
 */
public abstract class BasePoolingHttpClientFactory
	implements HttpClientFactory {

	@Override
	public HttpClient createInstance() throws Exception {
		if (_log.isDebugEnabled()) {
			_log.debug("Create instance");
		}

		_poolingClientConnectionManager =
			createPoolingHttpClientConnectionManager();

		applyProperties(_poolingClientConnectionManager);

		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

		httpClientBuilder.setConnectionManager(_poolingClientConnectionManager);

		applyProperties(httpClientBuilder);

		configure(httpClientBuilder);

		return httpClientBuilder.build();
	}

	public void setDefaultMaxConnectionsPerRoute(
		Integer defaultMaxConnectionsPerRoute) {

		_defaultMaxConnectionsPerRoute = defaultMaxConnectionsPerRoute;
	}

	public void setMaxTotalConnections(Integer maxTotalConnections) {
		_maxTotalConnections = maxTotalConnections;
	}

	@Override
	public void shutdown() {
		if (_log.isDebugEnabled()) {
			_log.debug("Shut down");
		}

		if (_poolingClientConnectionManager == null) {
			return;
		}

		int retry = 0;

		while (retry < 10) {
			PoolStats poolStats =
				_poolingClientConnectionManager.getTotalStats();

			int availableConnections = poolStats.getAvailable();

			if (availableConnections <= 0) {
				break;
			}

			if (_log.isDebugEnabled()) {
				_log.debug(
					StringBundler.concat(
						toString(), " is waiting on ", availableConnections,
						" connections"));
			}

			_poolingClientConnectionManager.closeIdleConnections(
				200, TimeUnit.MILLISECONDS);

			try {
				Thread.sleep(500);
			}
			catch (InterruptedException interruptedException) {
			}

			retry++;
		}

		_poolingClientConnectionManager.shutdown();

		_poolingClientConnectionManager = null;

		if (_log.isDebugEnabled()) {
			_log.debug(toString() + " was shut down");
		}
	}

	protected void addHttpRequestInterceptor(
		HttpRequestInterceptor httpRequestInterceptor) {

		_httpRequestInterceptors.add(httpRequestInterceptor);
	}

	protected void applyProperties(HttpClientBuilder httpClientBuilder) {
		for (HttpRequestInterceptor httpRequestInterceptor :
				_httpRequestInterceptors) {

			httpClientBuilder.addInterceptorFirst(httpRequestInterceptor);
		}
	}

	protected void applyProperties(
		PoolingHttpClientConnectionManager poolingHttpClientConnectionManager) {

		if (_defaultMaxConnectionsPerRoute != null) {
			poolingHttpClientConnectionManager.setDefaultMaxPerRoute(
				_defaultMaxConnectionsPerRoute.intValue());
		}

		if (_maxTotalConnections != null) {
			poolingHttpClientConnectionManager.setMaxTotal(
				_maxTotalConnections.intValue());
		}
	}

	protected abstract void configure(HttpClientBuilder httpClientBuilder);

	protected abstract PoolingHttpClientConnectionManager
			createPoolingHttpClientConnectionManager()
		throws Exception;

	protected void removeHttpRequestInterceptor(
		HttpRequestInterceptor httpRequestInterceptor) {

		_httpRequestInterceptors.remove(httpRequestInterceptor);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BasePoolingHttpClientFactory.class);

	private Integer _defaultMaxConnectionsPerRoute;
	private final List<HttpRequestInterceptor> _httpRequestInterceptors =
		new ArrayList<>();
	private Integer _maxTotalConnections;
	private PoolingHttpClientConnectionManager _poolingClientConnectionManager;

}