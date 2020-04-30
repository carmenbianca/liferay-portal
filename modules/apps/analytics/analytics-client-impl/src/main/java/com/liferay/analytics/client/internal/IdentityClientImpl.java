/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.client.internal;

import com.liferay.analytics.client.IdentityClient;
import com.liferay.analytics.data.binding.JSONObjectMapper;
import com.liferay.analytics.data.binding.internal.IdentityContextMessageJSONObjectMapper;
import com.liferay.analytics.model.IdentityContextMessage;
import com.liferay.petra.json.web.service.client.JSONWebServiceClient;
import com.liferay.petra.json.web.service.client.internal.JSONWebServiceClientImpl;
import com.liferay.portal.kernel.util.GetterUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Eduardo García
 */
public class IdentityClientImpl implements IdentityClient {

	@Override
	public String getUserId(IdentityContextMessage identityContextMessage)
		throws Exception {

		String jsonIdentityContextMessage = _jsonObjectMapper.map(
			identityContextMessage);

		String identityPath = String.format(
			"/%s%s", identityContextMessage.getDataSourceId(),
			_SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_PATH);

		if (_logger.isDebugEnabled()) {
			_logger.debug(
				"Sending identity request {} to destination {}//{}:{}{}",
				jsonIdentityContextMessage,
				_SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_PROTOCOL,
				_SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_HOST,
				_SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_PORT, identityPath);
		}

		_jsonWebServiceClient.setHostName(
			_SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_HOST);
		_jsonWebServiceClient.setHostPort(
			GetterUtil.getInteger(
				_SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_PORT));
		_jsonWebServiceClient.setProtocol(
			_SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_PROTOCOL);

		return _jsonWebServiceClient.doPostAsJSON(
			identityPath, jsonIdentityContextMessage);
	}

	private static final String _SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_HOST =
		System.getProperty(
			"identity.gateway.host", "contacts-prod.liferay.com");

	private static final String _SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_PATH =
		System.getProperty("identity.gateway.path", "/identity");

	private static final String _SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_PORT =
		System.getProperty("identity.gateway.port", "443");

	private static final String
		_SYSTEM_PROPERTY_VALUE_IDENTITY_GATEWAY_PROTOCOL = System.getProperty(
			"identity.gateway.protocol", "https");

	private static final Logger _logger = LoggerFactory.getLogger(
		IdentityClientImpl.class);

	private final JSONObjectMapper<IdentityContextMessage> _jsonObjectMapper =
		new IdentityContextMessageJSONObjectMapper();
	private final JSONWebServiceClient _jsonWebServiceClient =
		new JSONWebServiceClientImpl();

}