/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.rest.internal.endpoint.access.token;

import com.liferay.oauth2.provider.rest.internal.endpoint.constants.OAuth2ProviderRESTEndpointConstants;
import com.liferay.portal.kernel.util.InetAddressUtil;
import com.liferay.portal.remote.cors.annotation.CORS;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.rs.security.oauth2.common.Client;
import org.apache.cxf.rs.security.oauth2.services.AccessTokenService;

/**
 * @author Tomas Polesovsky
 */
@Path("/token")
public class LiferayAccessTokenService extends AccessTokenService {

	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@CORS(allowMethods = "POST")
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response handleTokenRequest(MultivaluedMap<String, String> params) {
		return super.handleTokenRequest(params);
	}

	@Override
	protected Client authenticateClientIfNeeded(
		MultivaluedMap<String, String> params) {

		String clientId = params.getFirst("client_id");

		if ((clientId != null) && clientId.isEmpty()) {
			reportInvalidClient();
		}

		String clientSecret = params.getFirst("client_secret");

		if ((clientSecret != null) && clientSecret.isEmpty()) {
			params.remove("client_secret");
		}

		Client client = super.authenticateClientIfNeeded(params);

		Map<String, String> properties = client.getProperties();

		MessageContext messageContext = getMessageContext();

		HttpServletRequest httpServletRequest =
			messageContext.getHttpServletRequest();

		String remoteAddr = httpServletRequest.getRemoteAddr();

		String remoteHost = httpServletRequest.getRemoteHost();

		try {
			InetAddress inetAddress = InetAddressUtil.getInetAddressByName(
				remoteAddr);

			remoteHost = inetAddress.getCanonicalHostName();
		}
		catch (UnknownHostException unknownHostException) {
		}

		properties.put(
			OAuth2ProviderRESTEndpointConstants.PROPERTY_KEY_CLIENT_REMOTE_ADDR,
			remoteAddr);
		properties.put(
			OAuth2ProviderRESTEndpointConstants.PROPERTY_KEY_CLIENT_REMOTE_HOST,
			remoteHost);

		return client;
	}

	@Override
	protected void injectContextIntoOAuthProviders() {
	}

}