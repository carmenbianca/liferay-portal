/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConnectionConfiguration;
import com.liferay.portal.search.elasticsearch7.internal.util.ClassLoaderUtil;

import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.security.KeyStore;

import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	configurationPid = "com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConnectionConfiguration",
	immediate = true, property = "operation.mode=REMOTE",
	service = ElasticsearchConnection.class
)
public class RemoteElasticsearchConnection extends BaseElasticsearchConnection {

	@Override
	public String getConnectionId() {
		if (_elasticsearchConnectionConfiguration != null) {
			return _elasticsearchConnectionConfiguration.connectionId();
		}

		return null;
	}

	@Override
	public OperationMode getOperationMode() {
		return OperationMode.REMOTE;
	}

	@Override
	public boolean isActive() {
		if (_elasticsearchConnectionConfiguration != null) {
			return _elasticsearchConnectionConfiguration.active();
		}

		return false;
	}

	@Activate
	protected void activate(Map<String, Object> properties) {
		try {
			_elasticsearchConnectionConfiguration =
				ConfigurableUtil.createConfigurable(
					ElasticsearchConnectionConfiguration.class, properties);
		}
		catch (Exception exception) {
		}
	}

	protected void configureSecurity(RestClientBuilder restClientBuilder) {
		restClientBuilder.setHttpClientConfigCallback(
			httpClientBuilder -> {
				httpClientBuilder.setDefaultCredentialsProvider(
					createCredentialsProvider());

				if (_elasticsearchConnectionConfiguration.httpSSLEnabled()) {
					httpClientBuilder.setSSLContext(createSSLContext());
				}

				return httpClientBuilder;
			});
	}

	protected CredentialsProvider createCredentialsProvider() {
		CredentialsProvider credentialsProvider =
			new BasicCredentialsProvider();

		credentialsProvider.setCredentials(
			AuthScope.ANY,
			new UsernamePasswordCredentials(
				_elasticsearchConnectionConfiguration.username(),
				_elasticsearchConnectionConfiguration.password()));

		return credentialsProvider;
	}

	@Override
	protected RestHighLevelClient createRestHighLevelClient() {
		String[] networkHostAddresses =
			_elasticsearchConnectionConfiguration.networkHostAddresses();

		HttpHost[] httpHosts = new HttpHost[networkHostAddresses.length];

		for (int i = 0; i < networkHostAddresses.length; i++) {
			httpHosts[i] = HttpHost.create(networkHostAddresses[i]);
		}

		RestClientBuilder restClientBuilder = RestClient.builder(httpHosts);

		if (_elasticsearchConnectionConfiguration.authenticationEnabled()) {
			configureSecurity(restClientBuilder);
		}

		Class<? extends RemoteElasticsearchConnection> clazz = getClass();

		return ClassLoaderUtil.getWithContextClassLoader(
			() -> new RestHighLevelClient(restClientBuilder), clazz);
	}

	protected SSLContext createSSLContext() {
		try {
			Path path = Paths.get(
				_elasticsearchConnectionConfiguration.truststorePath());

			InputStream is = Files.newInputStream(path);

			KeyStore keyStore = KeyStore.getInstance(
				_elasticsearchConnectionConfiguration.truststoreType());
			String truststorePassword =
				_elasticsearchConnectionConfiguration.truststorePassword();

			keyStore.load(is, truststorePassword.toCharArray());

			SSLContextBuilder sslContextBuilder = SSLContexts.custom();

			sslContextBuilder.loadKeyMaterial(
				keyStore, truststorePassword.toCharArray());
			sslContextBuilder.loadTrustMaterial(keyStore, null);

			return sslContextBuilder.build();
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	private volatile ElasticsearchConnectionConfiguration
		_elasticsearchConnectionConfiguration;

}