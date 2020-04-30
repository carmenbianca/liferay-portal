/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.resource;

import java.util.Set;

import javax.servlet.ServletConfig;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Javier Gamarra
 */
public interface OpenAPIResource {

	public default Response getOpenAPI(
			Application application, HttpHeaders httpHeaders,
			Set<Class<?>> resourceClasses, ServletConfig servletConfig,
			String type, UriInfo uriInfo)
		throws Exception {

		return getOpenAPI(resourceClasses, type);
	}

	public default Response getOpenAPI(
			Set<Class<?>> resourceClasses, String type)
		throws Exception {

		return null;
	}

}