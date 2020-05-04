/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.scope.liferay;

import org.osgi.framework.Bundle;

/**
 * Represents a context for the per-request scope check security procedure.
 *
 * @author Carlos Sierra Andrés
 */
public interface ScopeContext {

	/**
	 * Resets the state context's state.
	 */
	public void clear();

	/**
	 * Inserts the access token string into the context.
	 *
	 * @param accessToken the access token
	 */
	public void setAccessToken(String accessToken);

	/**
	 * Inserts the application name into the context.
	 *
	 * @param applicationName the application name
	 */
	public void setApplicationName(String applicationName);

	/**
	 * Inserts the OSGi bundle into the context.
	 *
	 * @param bundle the OSGi bundle
	 */
	public void setBundle(Bundle bundle);

	/**
	 * Inserts the portal instance's ID into the context.
	 *
	 * @param companyId the portal instance's ID
	 */
	public void setCompanyId(long companyId);

}