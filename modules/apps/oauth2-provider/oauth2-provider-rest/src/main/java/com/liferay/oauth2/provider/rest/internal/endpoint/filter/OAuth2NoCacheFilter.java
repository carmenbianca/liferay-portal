/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.rest.internal.endpoint.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tomas Polesovsky
 */
@Component(
	immediate = true,
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.OAuth2.Application)",
		"osgi.jaxrs.extension=true", "osgi.jaxrs.name=OAuth2NoCacheFilter"
	},
	service = ContainerResponseFilter.class
)
@Provider
public class OAuth2NoCacheFilter implements ContainerResponseFilter {

	@Override
	public void filter(
		ContainerRequestContext containerRequestContext,
		ContainerResponseContext containerResponseContext) {

		MultivaluedMap<String, Object> headers =
			containerResponseContext.getHeaders();

		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Expires", "0");
		headers.add("Pragma", "no-cache");
	}

}