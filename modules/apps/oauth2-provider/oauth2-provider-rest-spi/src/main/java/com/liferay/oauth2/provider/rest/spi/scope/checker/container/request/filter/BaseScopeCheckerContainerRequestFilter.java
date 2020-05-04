/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.rest.spi.scope.checker.container.request.filter;

import com.liferay.oauth2.provider.scope.liferay.OAuth2ProviderScopeLiferayAccessControlContext;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

/**
 * @author Marta Medio
 */
public abstract class BaseScopeCheckerContainerRequestFilter
	implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext containerRequestContext) {
		if (OAuth2ProviderScopeLiferayAccessControlContext.
				isOAuth2AuthVerified() &&
			!isContainerRequestContextAllowed(containerRequestContext)) {

			containerRequestContext.abortWith(
				Response.status(
					Response.Status.FORBIDDEN
				).build());
		}
	}

	protected abstract boolean isContainerRequestContextAllowed(
		ContainerRequestContext containerRequestContext);

}