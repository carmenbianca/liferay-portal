/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.http;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.solr7.configuration.SolrHttpClientFactoryConfiguration;

import java.util.Map;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author László Csontos
 * @author Bruno Farache
 * @author André de Oliveira
 */
@Component(
	configurationPid = "com.liferay.portal.search.solr7.configuration.SolrHttpClientFactoryConfiguration",
	immediate = true, property = "type=BASIC", service = HttpClientFactory.class
)
public class BasicAuthPoolingHttpClientFactory
	extends BasePoolingHttpClientFactory {

	public void setAuthScope(AuthScope authScope) {
		_authScope = authScope;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public void setUsername(String username) {
		_username = username;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_solrHttpClientFactoryConfiguration =
			ConfigurableUtil.createConfigurable(
				SolrHttpClientFactoryConfiguration.class, properties);

		int defaultMaxConnectionsPerRoute =
			_solrHttpClientFactoryConfiguration.defaultMaxConnectionsPerRoute();

		setDefaultMaxConnectionsPerRoute(defaultMaxConnectionsPerRoute);

		int maxTotalConnections =
			_solrHttpClientFactoryConfiguration.maxTotalConnections();

		setMaxTotalConnections(maxTotalConnections);

		String basicAuthPassword =
			_solrHttpClientFactoryConfiguration.basicAuthPassword();

		setPassword(basicAuthPassword);

		String basicAuthUserName =
			_solrHttpClientFactoryConfiguration.basicAuthUserName();

		setUsername(basicAuthUserName);
	}

	@Override
	protected void configure(HttpClientBuilder httpClientBuilder) {
		if (Validator.isBlank(_username)) {
			return;
		}

		if (_authScope == null) {
			_authScope = AuthScope.ANY;
		}

		if (Validator.isNull(_password)) {
			_password = StringPool.BLANK;
		}

		CredentialsProvider credentialsProvider =
			new BasicCredentialsProvider();

		credentialsProvider.setCredentials(
			_authScope, new UsernamePasswordCredentials(_username, _password));

		httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
	}

	@Override
	protected PoolingHttpClientConnectionManager
		createPoolingHttpClientConnectionManager() {

		return new PoolingHttpClientConnectionManager();
	}

	@Deactivate
	protected void deactivate() {
		shutdown();
	}

	@Reference(
		cardinality = ReferenceCardinality.AT_LEAST_ONE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	protected void setHttpRequestInterceptor(
		HttpRequestInterceptor httpRequestInterceptor) {

		addHttpRequestInterceptor(httpRequestInterceptor);
	}

	protected void unsetHttpRequestInterceptor(
		HttpRequestInterceptor httpRequestInterceptor) {

		removeHttpRequestInterceptor(httpRequestInterceptor);
	}

	private AuthScope _authScope;
	private String _password;
	private volatile SolrHttpClientFactoryConfiguration
		_solrHttpClientFactoryConfiguration;
	private String _username;

}