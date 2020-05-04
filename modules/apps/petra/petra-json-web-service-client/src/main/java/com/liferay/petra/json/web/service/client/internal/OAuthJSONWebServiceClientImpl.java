/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.web.service.client.internal;

import com.liferay.petra.json.web.service.client.JSONWebServiceTransportException;

import java.net.URI;

import java.util.Map;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;

import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.nio.reactor.IOReactorException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Ivica Cardic
 */
@Component(factory = "OAuthJSONWebServiceClient", service = {})
public class OAuthJSONWebServiceClientImpl extends JSONWebServiceClientImpl {

	@Override
	public void setOAuthAccessSecret(String oAuthAccessSecret) {
		_oAuthAccessSecret = oAuthAccessSecret;
	}

	@Override
	public void setOAuthAccessToken(String oAuthAccessToken) {
		_oAuthAccessToken = oAuthAccessToken;
	}

	@Override
	public void setOAuthConsumerKey(String oAuthConsumerKey) {
		_oAuthConsumerKey = oAuthConsumerKey;
	}

	@Override
	public void setOAuthConsumerSecret(String oAuthConsumerSecret) {
		_oAuthConsumerSecret = oAuthConsumerSecret;
	}

	@Activate
	protected void activate(Map<String, Object> properties)
		throws IOReactorException {

		setOAuthConsumerKey(getString("oAuthConsumerKey", properties));
		setOAuthConsumerSecret(getString("oAuthConsumerSecret", properties));

		super.activate(properties);
	}

	protected String buildURL(
		String hostName, int port, String protocol, String uri) {

		StringBuilder sb = new StringBuilder();

		sb.append(protocol);
		sb.append(":");
		sb.append("//");
		sb.append(hostName);

		if ((protocol.equals("http") && (port != 80)) ||
			(protocol.equals("https") && (port != 443))) {

			sb.append(":");
			sb.append(port);
		}

		sb.append(uri);

		return sb.toString();
	}

	protected OAuthConsumer getOAuthConsumer(
		String accessToken, String accessSecret) {

		OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(
			_oAuthConsumerKey, _oAuthConsumerSecret);

		oAuthConsumer.setTokenWithSecret(accessToken, accessSecret);

		return oAuthConsumer;
	}

	@Override
	protected void signRequest(HttpRequestBase httpRequestBase)
		throws JSONWebServiceTransportException.SigningFailure {

		if ((_oAuthAccessToken == null) && (_oAuthAccessSecret == null)) {
			throw new JSONWebServiceTransportException.SigningFailure(
				"OAuth credentials are not set", -1);
		}

		OAuthConsumer oAuthConsumer = getOAuthConsumer(
			_oAuthAccessToken, _oAuthAccessSecret);

		String requestURL = buildURL(
			getHostName(), getHostPort(), getProtocol(),
			String.valueOf(httpRequestBase.getURI()));

		httpRequestBase.setURI(URI.create(requestURL));

		try {
			oAuthConsumer.sign(httpRequestBase);
		}
		catch (OAuthException oAuthException) {
			throw new JSONWebServiceTransportException.SigningFailure(
				"Unable to sign HTTP request", oAuthException);
		}
	}

	private String _oAuthAccessSecret;
	private String _oAuthAccessToken;
	private String _oAuthConsumerKey;
	private String _oAuthConsumerSecret;

}